package ${package}.adapters.memory;

import java.util.UUID;

import ${package}.core.domain.common.IdGenertator;

import org.springframework.stereotype.Component;

@Component
public class InMemoryIdGenerator implements IdGenertator<String> {

    @Override
    public String next() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
