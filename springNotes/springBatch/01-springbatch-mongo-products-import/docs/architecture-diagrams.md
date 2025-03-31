# Architecture Diagrams

## Component Architecture

```plantuml
@startuml
!theme plain
skinparam componentStyle rectangle

package "Spring Batch MongoDB Product Import" {
    [REST API] as api
    [Batch Job Controller] as controller
    [Job Configuration] as jobConfig
    
    package "Batch Components" {
        [JSON Reader] as reader
        [Product Processor] as processor
        [MongoDB Writer] as writer
    }
    
    database "MongoDB" as mongodb
    
    [Product Repository] as repo
    
    file "products.json" as jsonFile
}

api --> controller
controller --> jobConfig
jobConfig --> reader
jobConfig --> processor
jobConfig --> writer
reader --> jsonFile
writer --> repo
repo --> mongodb
@enduml
```

## Batch Processing Flow

```plantuml
@startuml
!theme plain
skinparam activityDiamondBackgroundColor white
skinparam activityBackgroundColor lightyellow
skinparam arrowColor black

start
:Read JSON Products File;
repeat
    :Read Chunk of Products;
    :Process Each Product;
    note right
        - Generate UUID
        - Set timestamps
        - Set active status
    end note
    :Write Chunk to MongoDB;
repeat while (More Products?) is (yes)
->no;
:Job Complete;
stop
@enduml
```

## Class Diagram

```plantuml
@startuml
!theme plain
skinparam classFontSize 12
skinparam classAttributeFontSize 11

class Product {
    +id: String
    +name: String
    +description: String
    +category: String
    +price: Double
    +stockQuantity: Integer
    +manufacturer: String
    +sku: String
    +active: Boolean
    +createdDate: String
    +lastModifiedDate: String
}

class ProductDTO {
    +name: String
    +description: String
    +category: String
    +price: Double
    +stockQuantity: Integer
    +manufacturer: String
    +sku: String
}

interface ProductRepository {
    +findBySku(sku: String): Optional<Product>
    +findByCategory(category: String): List<Product>
    +findByManufacturer(manufacturer: String): List<Product>
    +findByPriceBetween(minPrice: Double, maxPrice: Double): List<Product>
    +findByActiveTrue(): List<Product>
}

class JsonProductReader {
    +createReader(resource: Resource): JsonItemReader<ProductDTO>
}

class ProductProcessor {
    +process(dto: ProductDTO): Product
}

class MongoProductWriter {
    -productRepository: ProductRepository
    +write(products: Chunk<Product>): void
}

ProductDTO --> Product : transforms to
MongoProductWriter --> ProductRepository : uses
ProductRepository --> Product : manages
@enduml
```

## Job Execution Sequence

```plantuml
@startuml
!theme plain
skinparam sequenceMessageAlign center

participant "REST API" as api
participant "Job Controller" as controller
participant "Job Launcher" as launcher
participant "Job" as job
participant "Step" as step
participant "Reader" as reader
participant "Processor" as processor
participant "Writer" as writer
participant "MongoDB" as mongodb

api -> controller : POST /api/batch/products/import
activate controller

controller -> launcher : run(job, parameters)
activate launcher

launcher -> job : execute()
activate job

job -> step : execute()
activate step

loop for each chunk
    step -> reader : read()
    activate reader
    reader --> step : ProductDTO
    deactivate reader

    step -> processor : process(ProductDTO)
    activate processor
    processor --> step : Product
    deactivate processor

    step -> writer : write(Chunk<Product>)
    activate writer
    writer -> mongodb : save products
    mongodb --> writer : confirmation
    writer --> step : complete
    deactivate writer
end

step --> job : StepExecution
deactivate step

job --> launcher : JobExecution
deactivate job

launcher --> controller : JobExecution
deactivate launcher

controller --> api : Job Status Response
deactivate controller
@enduml
```

These diagrams illustrate:
1. The overall component architecture and their interactions
2. The flow of batch processing operations
3. The class structure and relationships
4. The sequence of operations during job execution

They help in understanding:
- System components and their relationships
- Data flow through the system
- Processing steps and transformations
- Runtime behavior and interactions

