# Task 20.2 — Anti-Corruption Layer (ACL)

A tiny Java adapter that isolates a modern microservice from a legacy
system's XML shape. The new service only ever sees clean JSON DTOs.

```
Legacy XML  --->  [ACL Adapter]  --->  Modern JSON DTO
```

## Files
- `LegacyCustomerXmlClient.java`  — pretends to fetch XML from the legacy API.
- `ModernCustomerDto.java`        — the modern JSON DTO the new service uses.
- `LegacyCustomerAcl.java`        — the Anti-Corruption Layer: parses XML, maps fields, returns DTO.
- `Main.java`                     — small demo of end-to-end use.

## Why an ACL?
Without it, legacy field names, quirks, and null semantics leak into the
new domain model and "corrupt" it. The ACL is the single translation seam.
