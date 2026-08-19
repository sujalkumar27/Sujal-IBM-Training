# MCQ Test: Networking & Web Fundamentals

> Total Questions: 50 | Time Suggested: 60 minutes
> Topics: HTTP, HTTPS/TLS, Load Balancers, Client-Server Patterns, Troubleshooting Tools

---

## Topic 1: HTTP Protocol Fundamentals (Methods, Status Codes, Headers)

**Q1.** Which HTTP method is idempotent but NOT safe?
- A) GET
- B) POST
- C) PUT
- D) HEAD

**Q2.** What does HTTP status code `301` indicate?
- A) Resource temporarily moved
- B) Resource permanently moved
- C) Resource not found
- D) Bad request

**Q3.** Which HTTP method is typically used to partially update a resource?
- A) PUT
- B) POST
- C) PATCH
- D) UPDATE

**Q4.** What is the default port for HTTP?
- A) 21
- B) 22
- C) 80
- D) 443

**Q5.** Which status code range represents server-side errors?
- A) 2xx
- B) 3xx
- C) 4xx
- D) 5xx

**Q6.** The `Content-Type` header specifies:
- A) The size of the response body
- B) The media type of the resource being sent
- C) The encoding of the request
- D) The authorization method

**Q7.** Which header is used to enable caching control in HTTP/1.1?
- A) Expires
- B) Cache-Control
- C) Pragma
- D) ETag

**Q8.** What does status code `429` mean?
- A) Unauthorized
- B) Forbidden
- C) Too Many Requests
- D) Payment Required

**Q9.** Which HTTP method should NOT change server state?
- A) GET
- B) POST
- C) DELETE
- D) PATCH

**Q10.** Which header carries authentication credentials in a request?
- A) Cookie
- B) Authorization
- C) WWW-Authenticate
- D) Accept

---

## Topic 2: HTTPS and TLS Basics

**Q11.** HTTPS is essentially HTTP over which protocol?
- A) SSH
- B) TLS/SSL
- C) IPSec
- D) FTP

**Q12.** What is the default port for HTTPS?
- A) 80
- B) 8080
- C) 443
- D) 8443

**Q13.** During the TLS handshake, what is exchanged first between client and server?
- A) Session keys
- B) Client Hello / Server Hello messages
- C) Encrypted application data
- D) Digital certificates only

**Q14.** Which type of encryption is used for the actual data transfer once a TLS session is established?
- A) Asymmetric encryption
- B) Symmetric encryption
- C) Hashing
- D) Base64 encoding

**Q15.** What is the primary purpose of an SSL/TLS certificate?
- A) To compress data
- B) To authenticate the server's identity and enable encryption
- C) To speed up connections
- D) To block malicious IPs

**Q16.** Which of these is NOT provided by TLS?
- A) Confidentiality
- B) Integrity
- C) Authentication
- D) Compression of files on disk

**Q17.** A Certificate Authority (CA) is responsible for:
- A) Encrypting user passwords
- B) Issuing and verifying digital certificates
- C) Managing DNS records
- D) Routing HTTPS traffic

**Q18.** Which TLS version is currently considered the most secure and widely recommended?
- A) TLS 1.0
- B) TLS 1.1
- C) TLS 1.2
- D) TLS 1.3

**Q19.** In asymmetric encryption used by TLS, what is used to decrypt data that was encrypted with the server's public key?
- A) The client's public key
- B) The server's private key
- C) A shared symmetric key
- D) The CA's private key

**Q20.** What does the "S" in HTTPS stand for?
- A) Session
- B) Secure
- C) Server
- D) Standard

---

## Topic 3: Load Balancers and Reverse Proxies (Overview)

**Q21.** A load balancer primarily helps to:
- A) Encrypt HTTP traffic
- B) Distribute incoming traffic across multiple servers
- C) Store user sessions
- D) Compile source code

**Q22.** Which load balancing algorithm sends each new request to the next server in a list, cycling back to the first?
- A) Least Connections
- B) IP Hash
- C) Round Robin
- D) Random

**Q23.** A reverse proxy sits between:
- A) Two clients
- B) The client and backend servers
- C) Two databases
- D) The DNS and the client

**Q24.** Which OSI layer does a Layer 7 load balancer operate on?
- A) Network
- B) Transport
- C) Session
- D) Application

**Q25.** Which of the following is a common open-source reverse proxy / load balancer?
- A) MySQL
- B) NGINX
- C) Redis
- D) Kafka

**Q26.** Sticky sessions (session persistence) in load balancing mean:
- A) Sessions expire quickly
- B) A client is consistently routed to the same backend server
- C) All requests go through cache
- D) Sessions are encrypted

**Q27.** Which of the following is NOT a benefit of using a reverse proxy?
- A) SSL termination
- B) Caching static content
- C) Direct database access for clients
- D) Hiding backend server details

**Q28.** A Layer 4 load balancer makes routing decisions based on:
- A) URL path
- B) HTTP headers
- C) IP address and TCP/UDP port
- D) Cookies

**Q29.** SSL termination at a load balancer means:
- A) SSL is disabled
- B) The load balancer decrypts HTTPS traffic before sending it to backends
- C) The client cannot use HTTPS
- D) Only backend servers can decrypt requests

**Q30.** Which algorithm forwards new requests to the server currently handling the fewest active connections?
- A) Round Robin
- B) Least Connections
- C) Weighted Round Robin
- D) Random

---

## Topic 4: Client-Server Communication Patterns

**Q31.** Which communication pattern uses a persistent, full-duplex connection between client and server?
- A) HTTP polling
- B) Long polling
- C) WebSockets
- D) REST

**Q32.** In "long polling," the server:
- A) Closes the connection immediately
- B) Holds the request open until data is available or timeout occurs
- C) Sends data every second
- D) Sends only headers, no body

**Q33.** REST APIs are based on which architectural style?
- A) Stateful sessions with heavy coupling
- B) Stateless client-server communication over HTTP
- C) Peer-to-peer messaging
- D) Direct database access

**Q34.** Server-Sent Events (SSE) allow:
- A) Bidirectional real-time communication
- B) The server to push updates to the client over a single HTTP connection
- C) The client to push data to multiple servers
- D) Encrypted DNS queries

**Q35.** Which is a synchronous communication pattern?
- A) Message queue with async consumer
- B) Traditional HTTP request-response
- C) Publish-subscribe
- D) Event-driven webhook

**Q36.** In a publish-subscribe pattern, publishers:
- A) Send messages directly to specific subscribers
- B) Send messages to a broker/topic without knowing the subscribers
- C) Only respond to requests
- D) Receive messages from clients

**Q37.** gRPC primarily uses which underlying protocol for transport?
- A) HTTP/1.0
- B) HTTP/2
- C) FTP
- D) SMTP

**Q38.** Which of the following is a key characteristic of stateless communication?
- A) The server remembers each client's context
- B) Each request contains all information needed to process it
- C) Requests must be processed in order
- D) Connections stay open indefinitely

**Q39.** Webhooks are best described as:
- A) HTTP callbacks triggered by events from another system
- B) A type of database index
- C) A caching layer
- D) A load balancing method

**Q40.** Which pattern is most suitable for real-time chat applications?
- A) Simple HTTP polling
- B) WebSockets
- C) FTP
- D) SMTP

---

## Topic 5: Troubleshooting Tools (ping, curl, netstat)

**Q41.** The `ping` command primarily uses which protocol?
- A) TCP
- B) UDP
- C) ICMP
- D) HTTP

**Q42.** Which `curl` option sends a POST request with data?
- A) `curl -G`
- B) `curl -X POST -d "data"`
- C) `curl --head`
- D) `curl -I`

**Q43.** What does `netstat -an` typically show?
- A) A list of installed packages
- B) All active network connections and listening ports with numeric addresses
- C) Only DNS queries
- D) Kernel logs

**Q44.** Which `curl` flag is used to include the response headers in the output?
- A) `-v`
- B) `-i`
- C) `-s`
- D) `-o`

**Q45.** If `ping` returns "Request timed out," it most likely means:
- A) DNS resolution failed
- B) No ICMP reply received within the timeout period
- C) The remote server crashed
- D) The local network card is disabled

**Q46.** Which command would you use to check which process is listening on a specific TCP port?
- A) `ping <port>`
- B) `netstat -ano` (Windows) or `netstat -tulnp` (Linux)
- C) `curl <port>`
- D) `traceroute <port>`

**Q47.** The `curl -I <url>` command:
- A) Downloads the file quickly
- B) Fetches only the HTTP response headers (HEAD request)
- C) Uploads a file
- D) Ignores SSL errors

**Q48.** Which of these is the modern replacement for `netstat` on many Linux systems?
- A) `ifconfig`
- B) `ss`
- C) `route`
- D) `nslookup`

**Q49.** To follow HTTP redirects automatically with `curl`, you use:
- A) `-r`
- B) `-L`
- C) `-f`
- D) `-k`

**Q50.** If `ping google.com` fails but `ping 8.8.8.8` succeeds, the most likely issue is:
- A) The internet is down
- B) A DNS resolution problem
- C) A firewall blocking ICMP
- D) A routing loop

---

# Answer Key & Explanations

## Topic 1: HTTP Protocol Fundamentals

| Q  | Ans | Explanation |
|----|-----|-------------|
| 1  | C   | PUT is idempotent (repeated calls produce same result) but not safe (it modifies state). |
| 2  | B   | 301 = Moved Permanently. |
| 3  | C   | PATCH applies partial modifications; PUT replaces the entire resource. |
| 4  | C   | HTTP default port is 80. |
| 5  | D   | 5xx = Server Errors (e.g., 500, 502, 503). |
| 6  | B   | `Content-Type` specifies the MIME/media type (e.g., `application/json`). |
| 7  | B   | `Cache-Control` is the standard HTTP/1.1 caching directive header. |
| 8  | C   | 429 = Too Many Requests (rate limiting). |
| 9  | A   | GET is a safe method — it should only retrieve data. |
| 10 | B   | The `Authorization` header carries credentials (Basic, Bearer, etc.). |

## Topic 2: HTTPS and TLS Basics

| Q  | Ans | Explanation |
|----|-----|-------------|
| 11 | B   | HTTPS = HTTP over TLS (formerly SSL). |
| 12 | C   | HTTPS default port is 443. |
| 13 | B   | The handshake begins with Client Hello and Server Hello messages. |
| 14 | B   | Symmetric encryption is faster and used for bulk data after handshake. |
| 15 | B   | Certificates prove server identity and enable secure key exchange. |
| 16 | D   | TLS does not compress files on disk; it secures data in transit. |
| 17 | B   | CAs issue, sign, and verify digital certificates. |
| 18 | D   | TLS 1.3 is the newest and most secure widely adopted version. |
| 19 | B   | Only the server's private key can decrypt data encrypted with its public key. |
| 20 | B   | HTTPS = HyperText Transfer Protocol Secure. |

## Topic 3: Load Balancers and Reverse Proxies

| Q  | Ans | Explanation |
|----|-----|-------------|
| 21 | B   | Load balancers distribute traffic to improve availability and performance. |
| 22 | C   | Round Robin cycles requests sequentially across servers. |
| 23 | B   | A reverse proxy sits in front of backend servers on behalf of clients. |
| 24 | D   | Layer 7 = Application layer (HTTP-aware). |
| 25 | B   | NGINX is a popular open-source web server / reverse proxy / load balancer. |
| 26 | B   | Sticky sessions bind a client to the same backend for the duration of the session. |
| 27 | C   | Reverse proxies hide backends; clients do NOT access DBs directly. |
| 28 | C   | Layer 4 uses transport-layer info (IP + port), not HTTP details. |
| 29 | B   | SSL termination = LB decrypts HTTPS, forwarding plain HTTP internally. |
| 30 | B   | Least Connections routes to the server with fewest active connections. |

## Topic 4: Client-Server Communication Patterns

| Q  | Ans | Explanation |
|----|-----|-------------|
| 31 | C   | WebSockets provide a persistent, full-duplex TCP connection. |
| 32 | B   | Long polling holds the connection until data arrives or timeout. |
| 33 | B   | REST is stateless client-server over HTTP with standard verbs. |
| 34 | B   | SSE lets servers push events over a single long-lived HTTP connection (one-way). |
| 35 | B   | HTTP request-response is synchronous — the client waits for a reply. |
| 36 | B   | In pub-sub, publishers publish to a topic/broker; subscribers listen independently. |
| 37 | B   | gRPC is built on HTTP/2 with Protocol Buffers. |
| 38 | B   | Statelessness means each request is self-contained. |
| 39 | A   | Webhooks are user-defined HTTP callbacks triggered by events. |
| 40 | B   | WebSockets are ideal for real-time bidirectional chat. |

## Topic 5: Troubleshooting Tools

| Q  | Ans | Explanation |
|----|-----|-------------|
| 41 | C   | `ping` uses ICMP Echo Request/Reply. |
| 42 | B   | `curl -X POST -d "data"` sends a POST with the given data payload. |
| 43 | B   | `netstat -an` lists all connections and listening ports numerically. |
| 44 | B   | `-i` includes headers with the body; `-I` fetches only headers. |
| 45 | B   | Timeout means no ICMP reply received (could be firewall, host down, network). |
| 46 | B   | `netstat -ano` (Windows) / `netstat -tulnp` (Linux) shows PID and port. |
| 47 | B   | `curl -I` sends a HEAD request and prints headers only. |
| 48 | B   | `ss` is the modern, faster replacement for `netstat` on Linux. |
| 49 | B   | `-L` tells curl to follow `Location:` redirects. |
| 50 | B   | Name resolution failure while IP works = DNS problem. |

---

## Scoring Guide

| Score | Level |
|-------|-------|
| 45–50 | Expert |
| 35–44 | Proficient |
| 25–34 | Intermediate |
| 15–24 | Beginner — review core concepts |
| < 15  | Revisit fundamentals before retaking |

**Good luck!**
