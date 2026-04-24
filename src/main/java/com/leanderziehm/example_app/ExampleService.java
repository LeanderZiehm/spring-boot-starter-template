package com.leanderziehm.example_app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    public ExampleEntity addExample() {
        return addExample(new ExampleEntity("Example"));
    }

    public ExampleEntity addExample(ExampleEntity newEntity) {
        return exampleRepository.save(newEntity);
    }

    public String removeExampleById(Integer Id) {
        ExampleEntity foundEntity = exampleRepository.getReferenceById(Id);
        exampleRepository.delete(foundEntity);
        return "deleted entity";
    }

    public String replaceExampleById(Integer Id, ExampleEntity newEntity) {
        // Optional<ExampleEntity> foundEntity = exampleRepository.findById(Id);
        // foundEntity.map(example -> { example.setName(newEntity.getName());
        // exampleRepository.save(example); }).orElse(()->
        // exampleRepository.save(newEntity));
        exampleRepository.findById(Id).map(example -> {
            example.setName(newEntity.getName());
            return exampleRepository.save(example);
        }).orElseGet(() -> exampleRepository.save(newEntity));

        // .map(example -> {return exampleRepository.save(example) });
        // foundEntity.
        return "deleted entity";
    }

    // public String updateExampleById(Integer Id, ExampleEntity updatedEntity){
    // ExampleEntity foundEntity = exampleRepository.getReferenceById(Id);
    // foundEntity.
    // return "deleted entity";
    // }

    public List<ExampleEntity> listExamples() {
        return exampleRepository.findAll();
    }

}
