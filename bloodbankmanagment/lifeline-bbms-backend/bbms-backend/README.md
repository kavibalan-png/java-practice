# LifeLine BBMS — Backend (Spring Boot + MySQL)

REST API scaffold for the Blood Bank Management System. Pairs with the
`blood-bank-management-system.html` front-end demo (which currently runs
entirely in-browser with mock data) — wire the two together by replacing the
in-memory arrays in the HTML file's `<script>` with `fetch()` calls to these
endpoints.

## What's implemented

- **Entities / tables**: `donors`, `patients`, `blood_units`, `blood_requests`,
  `emergency_requests`, `waiting_queue`, `admins` (see `schema.sql`)
- **Data structures** (the actual assignment requirement, not just DB queries):
  - `InventoryService` — an in-memory `ConcurrentHashMap<bloodGroup, BloodUnit>`
    cache for O(1) availability lookups, synced to MySQL on every write.
  - `EmergencyQueueService` — a real `java.util.PriorityQueue<EmergencyRequest>`
    ordered by priority weight (Critical=4 → Normal=1), FIFO tie-break.
  - `WaitingQueueService` — a real `java.util.ArrayDeque` used as a FIFO queue;
    `processAvailable()` drains oldest-first once stock is replenished.
- **JWT auth** (`/api/auth/login`) + Spring Security filter chain
- **CRUD REST controllers** for donors, patients, inventory, requests,
  emergency queue, waiting queue, and basic reports

## Running it

1. Install Java 17+, Maven, and MySQL 8.
2. Create the database and run `src/main/resources/schema.sql` once
   (this seeds the 8 blood groups). **Before running it**, replace the
   placeholder admin password hash with a real BCrypt hash for `admin123`
   (e.g. via `new BCryptPasswordEncoder().encode("admin123")` in a scratch
   Java snippet, or a trusted bcrypt generator).
3. Update `src/main/resources/application.properties` with your MySQL
   credentials and (optionally) SMTP credentials for email notifications.
4. `mvn spring-boot:run`
5. API is available at `http://localhost:8080/api/...`

## Auth flow

```
POST /api/auth/login  { "username": "admin", "password": "admin123" }
→ { "token": "...", "username": "admin", "fullName": "Admin User" }
```

Send `Authorization: Bearer <token>` on all other requests.

## Key endpoints

| Method | Path | Purpose |
|---|---|---|
| GET/POST/PUT/DELETE | `/api/donors` | Donor CRUD, `?name=&bloodGroup=` search |
| GET/POST/PUT/DELETE | `/api/patients` | Patient CRUD, `?query=` search |
| GET | `/api/inventory` | Full HashMap availability snapshot |
| GET | `/api/inventory/{group}` | O(1) lookup for one blood group |
| POST | `/api/inventory/add-stock` | Add units, auto-drains matching waiting queue |
| GET/POST | `/api/blood-requests` | List / submit a request (issues or queues it) |
| GET/POST | `/api/emergency` | View priority queue / add an emergency case |
| POST | `/api/emergency/process-next` | Dequeue and process the top-priority case |
| GET | `/api/waiting-queue` | FIFO view of unfulfilled requests |
| GET | `/api/reports/*` | Usage, top groups, emergency cases, stock warnings |

## Not included (left for you to wire up for production)

- Refresh tokens / password reset
- PDF/Excel export endpoints (the front-end demo does this client-side)
- Real SMS gateway integration (stubbed in `NotificationService`)
- Pagination/sorting query params on list endpoints
- Integration tests
