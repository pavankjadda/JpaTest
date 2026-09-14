# Claude Code

@../AGENTS.md

`AGENTS.md` is the single source of truth for domain, stack, and conventions. Do not duplicate long-form project context
here. The rules below apply only to Claude Code and take precedence over any plugin or skill workflow.

## Task sizing

Pick the tier first, then act. When in doubt between tiers, pick the smaller one and say so in one line.

- **Trivial** (one file, under ~30 lines, intent is unambiguous): edit directly. No brainstorming, no plan mode, no
  subagents, no clarifying questions. Compile the touched module and report.
- **Medium** (a few files, one domain): the lead does the work directly. Read only the files involved. Skip plan mode
  unless the design has more than one reasonable shape.
- **Large** (cross-cutting, new feature, security or auth flow): brainstorm, then plan, then fan out to Sonnet
  subagents.

## Dispatch

- **Move fast once asked to change code.** A clear ask gets edits, not a proposal. Only an ambiguous or truncated ask
  gets a short proposal first.
- **Do not spawn subagents for trivial or medium work.** Every subagent re-reads the codebase from scratch, so
  delegating a small change is slower than doing it.

## Orchestration

- **Think on Opus or Fable.** Use `opus` or `fable` for planning, architecture, debugging, and any task that needs
  deeper reasoning. Do not use Sonnet as the lead thinking model.
- **Run the lead at `high` effort by default; use `xhigh` for planning and debugging sessions.** `xhigh` on routine
  edits produces long deliberation for no gain.
- **Escalate the lead to `fable`, do not fall back to it.** Fable is the more capable model and costs 2× per token
  ($10/$50 per MTok vs Opus at $5/$25). Escalate deliberately when a problem resists Opus — subtle stateful reasoning,
  Spring Security and auth-flow work, long-horizon agentic runs — not as the routine default. Raising effort on Opus
  does not reach Fable's ceiling; they are independent axes.
- **Execute on Sonnet.** Spawn coding and implementation subagents with `model: sonnet` at low or medium effort. Upgrade
  a stuck subagent to `opus` first, and only to `fable` if Opus also stalls.
- **Brief subagents completely.** Every subagent prompt names the exact files to touch, the AGENTS.md constraints that
  apply, and what "done" means, including the verification command. A vague brief makes the agent explore, which is the
  main cause of slow runs.
- **Parallelize independent work, up to 16 agents.** Split work into units with no overlapping files or shared state and
  launch them in the same turn. Run sequentially only when a step depends on another step's output. Do not pad with idle
  agents and do not exceed 16.

## Verification

- **Trivial and medium:** compile the touched module. Do not run the test suite unless asked.
- **Large:** run the affected test classes only.
- **Full test suite:** only on explicit request. It needs Vault and is slow.