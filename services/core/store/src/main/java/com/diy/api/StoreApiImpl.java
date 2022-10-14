package com.diy.api;

import com.diy.generated.api.StoreApi;
import com.diy.generated.model.StoreDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreApiImpl implements StoreApi {
    @Override
    public ResponseEntity<List<StoreDto>> findStores() {
        log.warn("azeaze");
        return null;
    }
}
