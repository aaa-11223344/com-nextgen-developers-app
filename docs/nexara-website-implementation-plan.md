# Nexara Institute Website Implementation Plan

## 1) Product Scope & Delivery Strategy

Build the platform in **6 releases** to avoid shipping risk and keep quality high:

1. **Foundation & Branding**
2. **Marketing Site + Program Pages**
3. **Admissions + Apply Flow (Auth + DB)**
4. **Student Portal MVP**
5. **Instructor/Admin/Venture Panels (MVP)**
6. **Polish, Performance, Analytics, Hardening**

---

## 2) Experience Direction (Dark Futuristic)

- Visual language: black/blue gradient base, neon accents, glass panels, subtle glow borders.
- Motion language:
  - Hero particle background.
  - Animated KPI counters on viewport entry.
  - Layered parallax sections.
  - Smooth route transitions and section reveal animations.
- Content tone: bold, execution-focused, systems-first (no motivational fluff).

---

## 3) Information Architecture (136-page ecosystem)

Use a route model grouped by domain:

- `/` Marketing + Institutional pages
- `/programs/*` all program pages and curriculum pages
- `/admissions/*` apply, eligibility, pricing, payment states
- `/events/*`, `/resources/*`, `/tools/*`
- `/portal/*` student area
- `/instructor/*`
- `/admin/*`
- `/venture/*`
- `/legal/*`

Create a **central route registry** (page ID + path + access role + seo metadata) so all 136 pages are trackable and can be generated systematically.

---

## 4) Mandatory Build Items Requested

## A. Authentication + Cloud

- Enable Lovable Cloud project.
- Configure auth:
  - Email/password login/signup.
  - Session persistence.
  - Protected route guards by role (public, student, instructor, admin, venture).
- Add role model now, even if some panels ship later.

## B. Apply Now (Multi-step + DB save)

Build `/admissions/apply-now` with:

- Multi-step form (recommended 6 steps):
  1. Personal info
  2. Program selection
  3. Background & experience
  4. Goals & commitment
  5. Portfolio/links
  6. Review + submit
- Features:
  - Auto-save draft to database at each step.
  - Resume progress after login.
  - Client + server validation.
  - Submission status tracking.
  - Confirmation page + email trigger.

Database entities:

- `users`
- `applications`
- `application_steps`
- `application_status_logs`

## C. 6 Program Detail Pages (full curriculum)

Build and launch these pages first:

1. `/programs/velyra-ai-core`
2. `/programs/velyra-creative-core`
3. `/programs/velyra-ai-pro`
4. `/programs/velyra-creator-pro`
5. `/programs/velyra-ai-mastery`
6. `/programs/velyra-creator-mastery`

Each page must include:

- Hero section + outcome statement.
- Full curriculum breakdown.
- Module accordions.
- Duration, level, mode, price, seat policy.
- CTA blocks: Enroll / Apply / Talk to advisor.
- FAQ + related programs + proof elements.

## D. Velyra Vision Dedicated Page

Build `/programs/velyra-vision` with:

- Division identity and positioning.
- Two-path model (Path A paid acceleration, Path B strategic partnership).
- Selection criteria, governance model, focus industries.
- 5-layer company engineering framework.
- Strong CTAs:
  - Apply for Path A
  - Apply for Path B
  - Book strategic call

---

## 5) Suggested Technical Architecture

- Frontend: component-driven architecture with shared design system.
- Data-driven content:
  - Store all curriculum/module structures in typed JSON/DB objects.
  - Render program pages from reusable templates.
- Backend services:
  - Auth service.
  - Application service.
  - CMS-like content service for program data.
- Analytics:
  - Funnel events (`view_program`, `start_apply`, `complete_step`, `submit_application`).

---

## 6) Build Phases (Detailed)

## Phase 1 — Foundation (Week 1)

- Finalize design tokens: color, typography, spacing, glow presets.
- Build layout primitives: navbar, footer, section shells, cards, accordions, CTA bars.
- Implement animation utilities (particles/counters/parallax/transitions).
- Configure SEO defaults + social metadata.

**Deliverables:** design system + animation framework + page scaffolding.

## Phase 2 — Core Public Pages (Weeks 2–3)

- Home page with strong narrative, stats counters, ecosystem map.
- About/Vision/Why Nexara/Ecosystem overview.
- Programs Hub with track filters and progression map.
- 6 detailed program pages + Velyra Vision page.

**Deliverables:** conversion-ready public foundation.

## Phase 3 — Admissions Engine (Weeks 3–4)

- Login/signup + session handling.
- Apply Now multi-step flow + database persistence.
- Eligibility checker + recommendation link hooks.
- Pricing/payment-plan pages + success/failure pages.

**Deliverables:** end-to-end enrollment pipeline.

## Phase 4 — Portal MVP (Weeks 5–6)

- Student dashboard, courses, progress, assignments, certificates shell.
- AI tool placeholders with access control.
- Profile, notifications, payment history.

**Deliverables:** usable student workspace.

## Phase 5 — Instructor/Admin/Venture MVP (Weeks 7–9)

- Instructor core tools.
- Admin analytics + user/course management basics.
- Venture panel starter flows for startup submissions.

**Deliverables:** operational back-office baseline.

## Phase 6 — Optimization & Launch (Weeks 10–12)

- Performance optimization (LCP/CLS/JS bundles).
- Accessibility and QA pass.
- Security hardening (auth, permissions, logs).
- Production observability + launch checklist.

**Deliverables:** stable production release.

---

## 7) Page Production Method for 136 Pages

- Use a **template-first strategy**:
  - Marketing template
  - Program template
  - Tool page template
  - Dashboard template
  - Management table template
- Generate pages from route registry + content configs.
- This avoids manual one-off implementation and keeps design consistency.

---

## 8) QA & Acceptance Criteria

- Every page passes responsive breakpoints.
- Animation performance remains smooth on mid-range devices.
- All protected routes enforce correct role guards.
- Application form:
  - Draft save works.
  - Step resume works.
  - Submission recorded and traceable.
- Program pages have complete curriculum accordions and working CTAs.

---

## 9) Immediate Next Sprint (Start Here)

Sprint goal: ship the first conversion-ready release.

1. Set up dark futuristic design tokens and motion framework.
2. Build Home + Programs Hub.
3. Build 6 program pages + Velyra Vision page.
4. Enable auth (signup/login).
5. Build Apply Now multi-step form with DB persistence.
6. Deploy to Lovable Cloud staging.

