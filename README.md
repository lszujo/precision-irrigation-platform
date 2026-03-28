# Precision Irrigation Platform

A backend-focused smart irrigation platform that combines sensor data, weather forecasts, and configurable surface or crop models to generate irrigation recommendations.

This project is designed to demonstrate practical software engineering across backend development, debugging, operations thinking, deployment, and system design. The long-term goal is to evolve it into a platform that can support multiple environments such as agriculture, tennis courts, golf turf, and landscaping by changing the decision model rather than rebuilding the system. Based on the project vision, the core intelligence lives in the backend decision engine, while the frontend stays lightweight and focused on visibility and control.

## Why I Built This

I am building this project to practice creating a serious system from scratch, not just contributing to an existing commercial codebase. It is intentionally designed to help me grow in:

* Java backend development
* debugging and troubleshooting
* DevOps and operational thinking
* platform and SRE-style engineering habits
* API integration
* system design
* deployment and observability

The system vision comes from a cloud-based decision platform that combines sensor readings, weather forecasts, and configurable models to recommend or trigger irrigation actions. fileciteturn0file0L1-L40

## Project Scope

The first version focuses on a simple but real end-to-end flow:

1. Receive or simulate sensor readings
2. Fetch weather data from an external API
3. Store readings and forecasts in PostgreSQL
4. Run decision logic in the backend
5. Return an irrigation recommendation through a REST API
6. Display the result in a minimal Angular frontend

Example recommendation flow from the project concept:

`Sensor reading -> Backend processing -> Decision engine -> Recommendation` fileciteturn0file0L41-L85

## Planned Architecture

```text
Sensors / Simulator
        |
        v
Sensor Ingestion Service
        |
        v
Spring Boot Backend
        |
        +--> Decision Engine
        |
        +--> Weather API Integration
        |
        +--> PostgreSQL
        |
        v
REST API
        |
        v
Angular Dashboard
```

The current project blueprint describes a backend-centered architecture with Spring Boot, PostgreSQL, weather integration, a dashboard/client layer, health monitoring, and failure handling. fileciteturn0file2L1-L64

## Repository Structure

This repository is currently organized as a monorepo so the whole system can be developed, run, and understood in one place.

```text
precision-irrigation-platform/
├── README.md
├── .gitignore
├── .env.example
├── docker-compose.yml
├── backend/
│   ├── README.md
│   ├── pom.xml
│   ├── Dockerfile
│   └── src/
├── frontend/
│   ├── README.md
│   ├── package.json
│   ├── angular.json
│   ├── Dockerfile
│   └── src/
├── sensor-simulator/
│   ├── README.md
│   └── src/
├── firmware/
│   ├── README.md
│   └── examples/
├── ops/
│   ├── README.md
│   ├── runbook.md
│   ├── scripts/
│   └── nginx/
├── architecture/
│   ├── diagram.png
│   └── decisions.md
└── docs/
    ├── screenshots/
    └── api-examples/
```

## Why a Monorepo

I am starting with a monorepo for a few reasons:

* it keeps the backend, frontend, simulator, firmware, and ops files together
* it makes local setup easier in the early stages
* it makes it easier to see the full system from one place
* it reduces coordination overhead while the project is still evolving
* it is a better fit for a solo builder starting from scratch

This is especially useful because the long-term system may include backend code, frontend code, device-side code, scripts, deployment files, and documentation.

If the project grows later, parts of it can be split into separate repositories when there is a clear reason to do so.

## Technology Stack

### Backend

* Java
* Spring Boot
* Maven
* REST APIs

### Frontend

* Angular
* TypeScript

### Data

* PostgreSQL

### Ops / Deployment

* Docker
* Docker Compose
* Nginx
* Linux

### Future / Hardware

* Raspberry Pi or microcontroller-based sensor integration
* C or C++ code for device-side logic

The original engineering blueprint also proposes Linux, Nginx, AWS EC2, Docker, health endpoints, and logging/monitoring as part of the system direction. fileciteturn0file2L20-L64

## Core Features

Planned first-version features:

* ingest sensor readings
* integrate weather forecast data
* store readings and recommendations in PostgreSQL
* support configurable crop or surface models
* generate irrigation recommendations
* provide a health endpoint
* expose a REST API for frontend consumption
* handle basic failure scenarios gracefully

The broader platform vision includes support for agriculture, clay tennis courts, grass courts, golf turf, and landscaping through configurable surface models. fileciteturn0file0L1-L40

## Example Decision Logic

Initial decision logic will be intentionally simple and rule-based.

Example:

```text
IF soil_moisture < minimum_threshold
AND forecasted_rain < rain_threshold
THEN recommend irrigation
```

This matches the project blueprint's idea of combining sensor data, weather forecasts, and model-specific thresholds to produce a recommendation. fileciteturn0file2L33-L47

## Failure Scenarios

A key part of this project is thinking like an operator, not only like a developer.

Planned failure scenarios:

* weather API unavailable
* sensor service offline
* database connection failure
* stale forecast data
* invalid sensor readings

The system should log problems, expose status through a health endpoint, and degrade gracefully where possible, such as falling back to cached weather data when an external weather API is unavailable. fileciteturn0file2L47-L84

## Health Endpoint

The backend will expose a health check endpoint such as:

```http
GET /health
```

Example response:

```json
{
  "status": "UP",
  "database": "connected",
  "weatherAPI": "reachable",
  "sensorService": "online"
}
```

This follows the operational direction described in the blueprint. fileciteturn0file2L52-L69

## Getting Started

This section is intentionally simple. The goal is to make the first version runnable before making it advanced.

### Step 1: Create the repository

Create a new GitHub repository named something like:

`precision-irrigation-platform`

### Step 2: Create the top-level folders

Create these folders first:

* `backend`
* `frontend`
* `sensor-simulator`
* `firmware`
* `ops`
* `architecture`
* `docs`

### Step 3: Start with the backend first

The backend is the center of the system. Start there.

Recommended first backend milestone:

* create Spring Boot app
* add one controller
* add one `/health` endpoint
* connect to PostgreSQL
* run the app locally

### Step 4: Add the frontend only after the backend runs

Keep the Angular frontend minimal at the beginning. It only needs to display:

* latest sensor reading
* latest weather summary
* latest irrigation recommendation

### Step 5: Add Docker after the local version works

Once backend and database work locally, add:

* backend Dockerfile
* frontend Dockerfile
* `docker-compose.yml`

## Local Development Plan

Recommended order of work:

1. initialize repo and folder structure
2. build Spring Boot backend skeleton
3. add PostgreSQL connection
4. add `/health` endpoint
5. add sensor reading endpoint
6. add weather API integration
7. add recommendation logic
8. add minimal Angular dashboard
9. add Docker Compose
10. document setup with screenshots

## API Ideas

Planned endpoints for the first version:

```http
GET  /health
GET  /api/recommendations/latest
GET  /api/weather/current
GET  /api/sensors/latest
POST /api/sensors/readings
```

These may change as the implementation becomes more concrete.

## Development Principles

A few rules for this project:

* keep the backend as the source of decision-making
* keep the frontend simple
* prefer simple working code over advanced architecture too early
* make the project easy to run locally
* document every important decision
* treat operability as a first-class feature

This aligns closely with the platform philosophy that the backend contains the main intelligence while the user interface remains lightweight and easy to update. fileciteturn0file0L13-L34

## Future Roadmap

Possible later additions:

* real IoT gateway integration
* Raspberry Pi sensor node
* C or C++ firmware examples
* irrigation valve control
* authentication and roles
* historical charts and analytics
* Prometheus and Grafana metrics
* cloud deployment on AWS
* surface-specific tuning
* automated irrigation instead of recommendation-only mode

The broader vision already anticipates IoT devices such as moisture probes, temperature sensors, weather stations, valve controllers, and pump relays. fileciteturn0file0L35-L63

## Current Status

This repository is under active development.

Right now the focus is on creating a clean, understandable foundation:

* strong repo structure
* runnable backend
* minimal frontend
* clear documentation
* room to grow into a more advanced platform later

## Author

Built as a serious hands-on engineering project to grow from software development into DevOps, SRE, and platform engineering.

