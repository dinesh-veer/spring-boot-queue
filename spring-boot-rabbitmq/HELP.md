
# 🐰 Spring Boot + RabbitMQ Example

<p align="center">
<b>Asynchronous messaging using Spring Boot, RabbitMQ (AMQP), JSON messaging, and Docker</b>
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-21%2B-blue?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring%20Boot-4-green?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/RabbitMQ-AMQP-orange?style=for-the-badge&logo=rabbitmq" />
<img src="https://img.shields.io/badge/Docker-Ready-blue?style=for-the-badge&logo=docker" />
</p>

---

# 📌 Overview

This project demonstrates **RabbitMQ messaging with Spring Boot** using:

- AMQP (Advanced Message Queuing Protocol)
- JSON-based messaging
- Exchange → Queue → Consumer flow
- Dockerized RabbitMQ setup

---

# 🧠 Architecture

````

Client → REST → Producer → Exchange → Queue → Consumer

```

---

# 📦 Project Structure

```

src/main/java/com/dinesh/rabbitmq
├── config
├── model
├── producer
├── consumer
└── controller

````

---

# 🐳 Run RabbitMQ with Docker

```bash
docker-compose up -d
````

### Access UI:

[http://localhost:15672](http://localhost:15672)

Login:

```
guest / guest
```

---

# ⚙️ Configuration

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

---

# 🔁 Messaging Flow

1. Producer sends message to **Exchange**
2. Exchange routes message using **Routing Key**
3. Message delivered to **Queue**
4. Consumer processes message

---

# 📤 Producer

* Converts Java object → JSON
* Sends message to exchange

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
  "orderId": "ORD-1",
  "product": "Phone",
  "quantity": 1
}
```

---

# 🧾 Output

```
Producing: {"orderId":"ORD-1","product":"Phone","quantity":1}
Received: OrderMessage(orderId=ORD-1,product=phone,quantity=1)
```
----

```http
GET localhost:8080?message=testmessage
```

# 🧾 Output
``` 
Send Message: testmessage
Receive Message: testmessage
```
----
### 📮 Postman Collection

A ready-to-use Postman collection is included to help you test the REST APIs quickly.

```text
spring-boot-rabbitmq/
└── SpringBootRabbitMQ.postman_collection.json
```

Import this collection into Postman and execute the sample requests provided.

---

### 📸 Screenshots

The module also contains screenshots of the [RabbitMQ Management UI](https://www.rabbitmq.com/docs/management?utm_source=chatgpt.com) to illustrate:

* Overview dashboard
* Exchanges and queues
* Message rates
* Published and consumed messages

```text
spring-boot-rabbitmq/screenshots/
├── rabbitmq-dashboard.png
├── rabbitmq-queues.png
└── rabbitmq-exchanges.png
```

---

# 🔥 Features

* ✅ AMQP messaging
* ✅ Exchange-based routing
* ✅ JSON messaging
* ✅ Docker integration
* ✅ Scalable architecture

---

# 🧠 Exchange Types (Quick Overview)

| Type   | Use Case              |
| ------ | --------------------- |
| Direct | Routing by key        |
| Fanout | Broadcast             |
| Topic  | Pattern-based routing |

---

# ⚠️ Notes

* Direct queue send uses default exchange (`""`)
* Exchange-based approach is recommended for production

---

# 🚀 Future Enhancements

* 🔁 Retry & Dead Letter Queue (DLQ)
* 📊 OpenTelemetry tracing
* ⚡ High-throughput tuning
* 🧩 Event-driven architecture

---

# 📬 Contact

**Dinesh Veer**

📧 [dveer123@hotmail.com](mailto:dveer123@hotmail.com)

🔗 [https://github.com/dinesh-veer](https://github.com/dinesh-veer)

---

# ⭐ Support

If this helps:

* ⭐ Star the repo
* 🍴 Fork it
* 📢 Share it

---

# 📜 License

[MIT License](../LICENSE)

