- Pfad
- Query-Parameter
- HTTP Verb: GET, PUT, POST, DELETE (HEAD, OPTIONS, PATCH, TRACE)
- Request Body

REST: Ressourcen
Produkte
Bestellungen
Kunden

Lade alle Produkte vom Server
GET /api/products

Erzeuge neues Produkt
POST /api/products

Lösche Produkt
DELETE /api/products/{id}

Lade Produkt mit bestimmter ID
GET /api/products/{id}

Update Produkt
PUT /api/products/{id}

*theoretisch noch möglich die Subressourcen zu ändern, das wird aber meist serverseitig gelöst und 
die ganze Ressource upgedatet*

Update Produktbeschreibung
PUT /api/products/{id}/description

Ändere Preis eines Produkts
PUT /api/products/{id}/price

*hier kommt eine Liste, daher bietet es sich an, die Subressource dem Request mitzugeben*
Füge Tags zu Produkt hinzu
POST /api/products/{id}/tags

Lade Produkte mit bestimmtem Tag
GET /api/products/{id}?tag={tag}&name={name} *mehrere Parameter möglich*

Ändere Preis eines Produkts
POST /api/updatePrice

Bestelle Produkt --> Erzeuge Bestellung
POST /api/orders

Füge Produkt zu Bestellung hinzu
PUT /api/orders/{id}/products


