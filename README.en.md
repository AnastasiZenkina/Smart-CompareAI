# **Smart Compare — AI-powered medical equipment comparison**

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

## **Project Description**
**What problem it solves**
Clinics and hospitals waste hours comparing medical equipment from different price lists. There is no single place to see the difference in price, certifications, rating, and stock availability and get a clear recommendation.

**Solution**
Smart Compare is a microservice that compares two products in seconds, fairly calculates their "value", and adds an AI explanation of why one is better. Built into a medical equipment marketplace ecosystem.


## **Key Features**
- Compares by 5 parameters: price, rating, certifications (FDA/CE/MOHAP/ISO), stock, category
- Automatic score calculation — open algorithm, not a black box
- Human-readable explanation via GPT-4o-mini (2-3 sentences, clear for doctors and buyers)
- Does not crash if AI is unavailable — fallback response ready
- Single REST endpoint, integrates in 10 minutes


## **Technologies**
Java 17 · Spring Boot 3.5.14 · Spring AI · OpenAI API · Lombok · Maven

## **Project Architecture**
Standard layered structure, ready to scale:

- `controller` — handles requests
- `service` — business logic and AI call
- `model` — request and response data
- `util` — score calculation formula (ScoreCalculator)


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

## **AI Models**
- **GPT-4o-mini** (OpenAI) — lightweight model, one comparison costs ~$0.0001
- Prompt strictly sets the role: "AI procurement assistant for medical equipment marketplace"
- Response is always short and professional

## **Security**
- OpenAI API key is stored in `application.yml` (not in code)
- In production use environment variable `OPENAI_API_KEY`
- No user data in logs

## **Contacts**
[LinkedIn](https://linkedin.com/in/anastasiazenkina) · [Email](mailto:asiazenkina@gmail.com) · [Telegram](https://t.me/asiazenkina)
