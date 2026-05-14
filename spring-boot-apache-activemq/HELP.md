

# 🚀 Spring Boot + Apache ActiveMQ (JMS) Example

<p align="center">
<b>Asynchronous messaging using Spring Boot 4, ActiveMQ, JSON messaging, and Docker</b>
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-21%2B-blue?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring%20Boot-4-green?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/ActiveMQ-JMS-orange?style=for-the-badge" />
<img src="https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker" />
</p>

---

# 📌 Overview

This project demonstrates **asynchronous messaging using Apache ActiveMQ** with:

- Spring Boot 4 (Jakarta JMS)
- JSON-based messaging
- Producer → Queue → Consumer flow
- Dockerized ActiveMQ broker

---

# 🧠 Architecture

```

Client → REST API → Producer → ActiveMQ Queue → Consumer

```

---

# 📦 Project Structure

```

src/main/java/com/dinesh/activemq
├── config
├── model
├── producer
├── consumer
└── controller

````

---

# 🐳 Run ActiveMQ with Docker

```bash
docker-compose up -d
````

### Access UI:

[http://localhost:8161](http://localhost:8161)

Login:

```
admin / admin
```

---

# ⚙️ Configuration

```yaml
spring:
  activemq:
    broker-url: tcp://localhost:61616
    user: admin
    password: admin
```

---

# 📤 Producer

* Converts Java object → JSON
* Sends message to queue

---

# 📥 Consumer

* Receives JSON message
* Converts → Java object

---

# 🧪 Test API

```http
POST localhost:8080
```

```json
{
  "orderId": "ORD-101",
  "product": "Laptop",
  "quantity": 2
}
```

---

# 🧾 Output

```
Producing JSON:  {"orderId":"ord-1","product":"laptop","quantity":10}
Received Object: OrderMessage(orderId=ord-1, product=laptop, quantity=10)
```

---


```http
GET localhost:8080?message=testmessage
```

# 🧾 Output
``` 
Send Message: testmessage
Receive Message: testmessage
```
---

### 📮 Postman Collection

A ready-to-use Postman collection is included to help you test the REST APIs quickly.

```text
spring-boot-apache-activemq
└── SpringBootActiveMQ.postman_collection.json
```

Import this collection into Postman and execute the sample requests provided.

---

### 📸 Screenshots

The module also contains screenshots of the [Apache ActiveMQ Classic Web Console](https://activemq.apache.org/components/classic/documentation/web-console?utm_source=chatgpt.com) to illustrate:

* Broker dashboard
* Queue details
* Enqueued and dequeued message counts
* Message browsing

```text
spring-boot-apache-activemq/screenshots/
├── activemq-dashboard.png
├── activemq-queues.png
└── activemq-message-browser.png
```

---


# 🔥 Features

* ✅ JMS-based messaging
* ✅ JSON serialization (modern approach)
* ✅ Decoupled architecture
* ✅ Docker support
* ✅ Spring Boot 4 compatible

---

# ⚠️ Notes

* `MappingJackson2MessageConverter` is deprecated → using manual JSON
* JMS does not propagate tracing automatically

---

# 🚀 Future Enhancements

* 🔁 Retry & Dead Letter Queue (DLQ)
* 📊 OpenTelemetry tracing
* ⚡ Virtual thread consumers
* 🧩 Message versioning

---

# 📬 Contact

**Dinesh Veer**

📧 [dveer123@hotmail.com](mailto:dveer123@hotmail.com)
🔗 [https://github.com/dinesh-veer](https://github.com/dinesh-veer)

---

# ⭐ Support

If you found this useful:

* ⭐ Star the repo
* 🍴 Fork it
* 📢 Share it

---

# 📜 License

MIT License
