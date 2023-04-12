package springFramework.springPetClinic.services.map;

import springFramework.springPetClinic.model.BaseEntity;

import java.util.*;

/**
Store data into a hash map:
A Java abstract class is a class which cannot be instantiated,
meaning you cannot create new instances of an abstract class.
The purpose of an abstract class is to function as a base for subclasses.
 */

// Customize T and ID
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){
        if(object != null) {
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) { // handles if map is empty
            nextId = 1L;
        }

        return nextId;
    }
}
