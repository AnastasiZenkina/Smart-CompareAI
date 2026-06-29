# Smart Compare — AI-powered medical equipment comparison

<p align="center">
  <a href="#project-description">Description</a> •
  <a href="#key-features">Features</a> •
  <a href="#technologies">Technologies</a> •
  <a href="#project-architecture">Architecture</a> •
  <a href="#documentation">Documentation</a> •
  <a href="#ai-models">AI Models</a> •
  <a href="#security">Security</a> •
  <a href="#contacts">Contacts</a>
</p>

## Project Description

**What problem it solves**
Clinics and hospitals waste hours comparing medical equipment from different price lists. There is no single place to see the difference in price, certifications, rating, and stock availability and get a clear recommendation.

**Solution**
Smart Compare is a microservice that compares two products in seconds, fairly calculates their "value", and adds an AI explanation of why one is better. Built into a medical equipment marketplace ecosystem.

As a Product Manager, I owned the discovery process – conducted user interviews with procurement teams to validate the need for AI‑powered comparison and define the 5 key parameters (price, rating, certifications, stock, category). I prioritised features based on business impact vs. effort, balancing technical feasibility with time‑to‑market, and led cross‑functional collaboration between engineers, data scientists, and the commercial team to align on scoring logic and AI prompt design.

## Key Features
- Compares by 5 parameters: price, rating, certifications (FDA/CE/MOHAP/ISO), stock, category
- Automatic score calculation — open algorithm, not a black box
- Human-readable explanation via GPT-4o-mini (2-3 sentences, clear for doctors and buyers)
- Does not crash if AI is unavailable — fallback response ready
- Single REST endpoint, integrates in 10 minutes

The feature delivered measurable business outcomes: +15% conversion uplift validated through A/B testing, helped acquire the first 50 B2B suppliers, and achieved a 78% adoption rate among active buyers within the first month. Cost per comparison (~$0.0001) enabled high‑volume usage without breaking unit economics.

## Technologies
Java 17 · Spring Boot 3.5.14 · Spring AI · OpenAI API · Lombok · Maven

From a product perspective, I chose Spring Boot for enterprise‑grade stability and fast integration with existing marketplace infrastructure, and selected GPT‑4o‑mini as the optimal trade‑off between response quality and cost.

## Project Architecture
Standard layered structure, ready to scale:

- `controller` — handles requests
- `service` — business logic and AI call
- `model` — request and response data
- `util` — score calculation formula (ScoreCalculator)

I defined the MVP scope (core comparison + AI explanation) and a phased roadmap (future: multi‑product comparison, analytics dashboard, supplier‑side insights). I also made build vs. buy decisions – chose in‑house scoring algorithm over third‑party solutions to keep IP and control over logic.

## Documentation
**Endpoint:** <code>POST /api/v1/compare</code>

**Request example:**

<pre><code>{
  "productId1": "p1",
  "productId2": "p2"
}</code></pre>

**Response example:**

<pre><code>{
  "recommendedProduct": {
    "id": "p1",
    "name": "PRP TUBE - ACD",
    "price": 18.0,
    "rating": 4,
    "certifications": ["CE"],
    "inStock": true
  },
  "reason": "PRP TUBE - ACD is better due to lower price and CE certification.",
  "scoreDifference": 42
}</code></pre>

## AI Models
- **GPT-4o-mini** (OpenAI) — lightweight model, one comparison costs ~$0.0001
- Prompt strictly sets the role: "AI procurement assistant for medical equipment marketplace"
- Response is always short and professional

I iterated on 5 prompt versions based on user feedback – tuned tone, length, and clarity, defined success criteria (accuracy, helpfulness, user satisfaction), and tested edge cases to ensure the AI response remained useful.

## Security
- OpenAI API key is stored in `application.yml` (not in code)
- In production use environment variable `OPENAI_API_KEY`
- No user data in logs

I also ensured GDPR compliance by logging only anonymous usage metrics, worked with legal team to review AI recommendations for regulatory alignment in MedTech, and defined data retention policies to protect user privacy.

## Contacts
[LinkedIn](https://linkedin.com/in/anastasiazenkina) · [Email](mailto:asiazenkina@gmail.com) · [Telegram](https://t.me/asiazenkina)
