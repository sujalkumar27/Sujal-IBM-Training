# Cheat Sheet: Networking & Web Fundamentals

> Master these five topics before taking the MCQ test.
> Read top-to-bottom once, then re-scan the **bold** terms and tables.

---

## 1. HTTP Protocol Fundamentals

### What is HTTP?
- **HyperText Transfer Protocol** — stateless, text-based, request/response protocol.
- Runs over **TCP** (usually port **80**).
- Every request is independent — server doesn't remember previous requests (statelessness).

### HTTP Methods (Verbs)

| Method  | Purpose                     | Safe? | Idempotent? |
|---------|-----------------------------|-------|-------------|
| GET     | Retrieve a resource         | Yes   | Yes         |
| HEAD    | Same as GET but headers only| Yes   | Yes         |
| POST    | Create / submit data        | No    | No          |
| PUT     | Replace entire resource     | No    | Yes         |
| PATCH   | Partial update              | No    | No*         |
| DELETE  | Remove a resource           | No    | Yes         |
| OPTIONS | Ask what methods are allowed| Yes   | Yes         |

- **Safe** = doesn't change server state.
- **Idempotent** = calling N times = calling once (same result).

### HTTP Status Codes

| Range | Meaning         | Common Examples                             |
|-------|-----------------|---------------------------------------------|
| 1xx   | Informational   | 100 Continue                                |
| 2xx   | Success         | 200 OK, 201 Created, 204 No Content         |
| 3xx   | Redirection     | 301 Moved Permanently, 302 Found, 304 Not Modified |
| 4xx   | Client Error    | 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found, 429 Too Many Requests |
| 5xx   | Server Error    | 500 Internal Server Error, 502 Bad Gateway, 503 Service Unavailable, 504 Gateway Timeout |

### Key HTTP Headers

**Request Headers**
- `Host` — target domain
- `User-Agent` — client software info
- `Accept` — accepted response media types
- `Authorization` — credentials (Basic, Bearer token, etc.)
- `Cookie` — sends stored cookies
- `Content-Type` — media type of request body
- `Content-Length` — size of body in bytes

**Response Headers**
- `Content-Type` — media type of response body (e.g., `application/json`)
- `Content-Length` — response body size
- `Set-Cookie` — server sets a cookie
- `Cache-Control` — caching rules (`no-cache`, `max-age=3600`, etc.)
- `ETag` — resource version identifier
- `Location` — used with 3xx redirects
- `WWW-Authenticate` — challenge for auth

### Quick memory hooks
- **80 = HTTP, 443 = HTTPS**
- **4xx = you (client) messed up. 5xx = server messed up.**
- **PUT replaces, PATCH tweaks.**

---

## 2. HTTPS and TLS Basics

### HTTPS = HTTP over TLS
- Adds **Confidentiality**, **Integrity**, **Authentication** to HTTP.
- Default port **443**.
- TLS replaced the older SSL (SSL is deprecated).

### TLS Versions
- TLS 1.0 / 1.1 — **deprecated / insecure**.
- TLS 1.2 — widely used, secure.
- **TLS 1.3** — latest, fastest, most secure. (Prefer this.)

### The TLS Handshake (simplified)
1. **Client Hello** — client sends supported TLS versions, cipher suites, random number.
2. **Server Hello** — server picks version/cipher, sends its **certificate** (contains public key), random number.
3. **Certificate Verification** — client verifies certificate via a **Certificate Authority (CA)**.
4. **Key Exchange** — client and server derive a **shared symmetric session key** (using asymmetric crypto).
5. **Encrypted Session** — from here on, all data uses **symmetric encryption** (fast).

### Encryption Types Used
| Type       | Where used                     | Why                   |
|------------|--------------------------------|-----------------------|
| Asymmetric | Handshake, key exchange        | Secure but slow       |
| Symmetric  | Data transfer after handshake  | Very fast             |
| Hashing    | Integrity checks (HMAC)        | Detect tampering      |

### Certificates
- Issued by a **Certificate Authority (CA)** (e.g., Let's Encrypt, DigiCert).
- Contain: public key, domain name, expiry, CA signature.
- Browser trusts a cert if it chains to a **trusted root CA**.

### What TLS Does NOT Do
- Doesn't encrypt data **at rest** (only in transit).
- Doesn't hide **which domain** you're visiting (SNI leaks it — mostly).
- Doesn't protect against a compromised endpoint.

### Quick memory hooks
- **HTTPS = HTTP + TLS on port 443.**
- **Handshake: asymmetric. Data transfer: symmetric.**
- **Server's private key ↔ Server's public key.**

---

## 3. Load Balancers and Reverse Proxies

### Load Balancer (LB)
- Distributes incoming traffic across multiple backend servers.
- Goals: **high availability, scalability, fault tolerance, performance**.

### Reverse Proxy
- Sits between clients and backend servers.
- Clients talk to the proxy; the proxy talks to backends.
- **Forward proxy** = on client side (protects client identity).
- **Reverse proxy** = on server side (protects server identity).

> Every reverse proxy can be a load balancer; not every load balancer is a full reverse proxy (but in practice they overlap heavily — NGINX, HAProxy, Envoy do both).

### Layer 4 vs Layer 7 Load Balancing

| Feature       | Layer 4 (Transport)          | Layer 7 (Application)                   |
|---------------|------------------------------|-----------------------------------------|
| Sees          | IP + TCP/UDP port            | Full HTTP request (URL, headers, cookies)|
| Faster?       | Yes (less processing)        | No (deeper inspection)                  |
| Smart routing?| Limited                      | Yes — route by path, host, header       |
| Example       | AWS NLB, TCP-mode HAProxy    | AWS ALB, NGINX, Envoy                   |

### Load Balancing Algorithms

| Algorithm            | How it works                                           |
|----------------------|--------------------------------------------------------|
| **Round Robin**      | Cycles through servers in order                        |
| **Weighted RR**      | Round robin but bigger weight = more traffic           |
| **Least Connections**| Send to the server with fewest active connections      |
| **IP Hash**          | Hash client IP → same client always hits same server   |
| **Random**           | Pick a random backend                                  |

### Key Features / Concepts
- **Health checks** — LB pings backends; removes unhealthy ones from rotation.
- **Sticky sessions (session affinity)** — same client → same backend (used when session state is server-local).
- **SSL/TLS termination** — LB decrypts HTTPS, forwards plain HTTP to backends (offloads CPU work).
- **SSL passthrough** — LB forwards encrypted traffic straight through; backend does decryption.

### Reverse Proxy Benefits
- Load balancing
- SSL termination
- **Caching** (static content)
- **Compression** (gzip)
- **Security** (WAF, rate limiting, hiding backend IPs)
- **URL rewriting / routing**

### Common Tools
- **NGINX** — reverse proxy, LB, web server
- **HAProxy** — high-performance LB
- **Envoy** — modern service proxy (used in service meshes)
- **AWS ELB (ALB / NLB / GLB)** — managed cloud LB
- **Cloudflare** — reverse proxy + CDN + WAF

### Quick memory hooks
- **L4 = fast, dumb. L7 = smart, HTTP-aware.**
- **Reverse proxy = "for the server". Forward proxy = "for the client".**
- **NGINX is the Swiss Army knife.**

---

## 4. Client-Server Communication Patterns

### Request-Response (HTTP)
- Classic model: client sends a request → server sends one response → done.
- **Synchronous**, **stateless** (with REST).

### REST (Representational State Transfer)
- Architecture, not a protocol.
- Uses HTTP verbs on resources (`GET /users/42`).
- **Stateless** — each request self-contained.
- Returns JSON (usually).

### RPC / gRPC
- Call a remote function like a local one.
- **gRPC** = Google's RPC framework over **HTTP/2** using **Protocol Buffers** (binary).
- Great for microservices; supports streaming.

### Polling
- Client repeatedly asks server for new data on a timer.
- Simple but wasteful (many empty responses).

### Long Polling
- Client sends request; server holds it open until data is ready or timeout.
- Better than polling; more efficient.

### Server-Sent Events (SSE)
- **One-way**: server pushes updates to client over a single HTTP connection.
- Text-based, easy to implement.
- Great for: live feeds, notifications, stock tickers.

### WebSockets
- **Full-duplex**, **persistent** TCP connection.
- Both client and server can send messages any time.
- Best for: **chat, real-time games, collaborative editing, live trading**.
- Upgraded from an HTTP handshake (`Upgrade: websocket`).

### Comparison Table

| Pattern       | Direction    | Persistent? | Overhead | Use Case               |
|---------------|--------------|-------------|----------|------------------------|
| HTTP Polling  | Client→Server| No          | High     | Simple periodic checks |
| Long Polling  | Client→Server| Kind of     | Medium   | Chat fallback          |
| SSE           | Server→Client| Yes         | Low      | Notifications, feeds   |
| WebSockets    | Bidirectional| Yes         | Low      | Real-time apps         |
| gRPC          | Bidirectional| Yes (HTTP/2)| Very low | Microservices          |

### Async Patterns
- **Publish-Subscribe (Pub/Sub)** — publishers send to a **topic**; subscribers get messages from that topic. Publishers don't know subscribers.
- **Message Queues** — producers put messages in a queue; consumers pull them off. Enables async, decoupled systems (Kafka, RabbitMQ, SQS).
- **Webhooks** — "reverse API": event happens → external system POSTs to your URL.

### Sync vs Async
- **Synchronous** — caller waits for response (HTTP request-response).
- **Asynchronous** — caller sends and moves on; response arrives later or via callback (queues, webhooks).

### Quick memory hooks
- **REST = stateless HTTP with verbs.**
- **WebSocket = phone call. HTTP = letter.**
- **SSE = one-way server → client. WebSocket = two-way.**
- **Webhook = "call me when it happens."**

---

## 5. Troubleshooting Tools (ping, curl, netstat)

### `ping` — Is the host reachable?
- Uses **ICMP Echo Request/Reply**.
- Measures round-trip time (RTT) and packet loss.

```
ping google.com
ping -c 4 8.8.8.8         # Linux: send 4 packets
ping -n 4 8.8.8.8         # Windows: send 4 packets
```

**Interpreting results:**
- Replies with times → host reachable.
- "Request timed out" → no reply (firewall / host down / network issue).
- `ping google.com` fails but `ping 8.8.8.8` works → **DNS problem**.

### `curl` — Swiss army knife for HTTP

```
curl https://example.com                     # basic GET
curl -I https://example.com                  # HEAD only (headers)
curl -i https://example.com                  # include response headers
curl -v https://example.com                  # verbose (show handshake)
curl -L https://example.com                  # follow redirects
curl -o out.html https://example.com         # save to file
curl -X POST -d "name=sujal" https://api...  # POST with form data
curl -X POST -H "Content-Type: application/json" -d '{"a":1}' https://api...
curl -H "Authorization: Bearer TOKEN" ...    # set header
curl -k https://self-signed.example          # ignore SSL errors
curl -u user:pass https://example.com        # basic auth
curl --max-time 10 https://example.com       # timeout
```

**Key flags to memorize:**
| Flag | Meaning                        |
|------|--------------------------------|
| -X   | HTTP method                    |
| -d   | Request body / form data       |
| -H   | Add a header                   |
| -I   | HEAD request (headers only)    |
| -i   | Include response headers       |
| -v   | Verbose                        |
| -L   | Follow redirects               |
| -o   | Output to file                 |
| -k   | Insecure (skip cert check)     |
| -u   | User:password (basic auth)     |

### `netstat` — What's connected / listening?

```
netstat -an          # all connections, numeric addresses
netstat -tulnp       # Linux: TCP/UDP listening ports with PID
netstat -ano         # Windows: all with PID
netstat -r           # routing table
```

**Column meanings:** Proto | Local Address | Foreign Address | State | PID

**Common states:**
- `LISTEN` — server waiting for connections
- `ESTABLISHED` — active connection
- `TIME_WAIT` — recently closed, holding port
- `CLOSE_WAIT` — remote closed, waiting for local close

### `ss` — modern replacement for `netstat` (Linux)
```
ss -tulnp            # same job as netstat -tulnp but faster
```

### Other useful tools (bonus)
- **`traceroute` / `tracert`** — path packets take to a host (each hop).
- **`nslookup` / `dig`** — DNS lookups.
- **`telnet host port`** — test if a TCP port is open.
- **`nc` (netcat)** — swiss army knife for TCP/UDP.
- **`ipconfig` (Windows) / `ifconfig` or `ip a` (Linux)** — network interface info.

### Debugging Flow (mental checklist)
1. **Is the host reachable?** → `ping IP`
2. **Is DNS working?** → `ping domain`, `nslookup domain`
3. **Is the port open?** → `telnet host port` or `nc -zv host port`
4. **Is the service responding?** → `curl -v http://host:port/`
5. **What's listening locally?** → `netstat -an` / `ss -tulnp`
6. **Where does the packet get lost?** → `traceroute host`

### Quick memory hooks
- **ping = ICMP. curl = HTTP. netstat = local sockets.**
- **`-I` = HEAD only. `-i` = include headers. Different!**
- **Ping by IP works, by name fails = DNS.**

---

# Final 60-Second Cram Card

- **HTTP ports: 80 / 443. Verbs: GET, POST, PUT, PATCH, DELETE. Status: 2xx OK, 3xx redirect, 4xx you, 5xx server.**
- **HTTPS = HTTP + TLS. Handshake uses asymmetric; data uses symmetric. TLS 1.3 is best.**
- **Load balancers: L4 (IP/port) vs L7 (HTTP). Algorithms: Round Robin, Least Connections, IP Hash. NGINX is king.**
- **Comms: REST (stateless HTTP), WebSockets (full-duplex), SSE (server→client), gRPC (HTTP/2 + protobuf), Webhooks (event callbacks).**
- **Tools: `ping` (ICMP), `curl` (HTTP; -I head, -i include, -L follow, -X method, -d data, -H header), `netstat -an` / `ss -tulnp` for sockets.**

Good luck — you've got this. Tell me when you're ready and we can run the test.
