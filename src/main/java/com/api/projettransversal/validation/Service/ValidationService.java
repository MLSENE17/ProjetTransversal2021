package com.api.projettransversal.validation.Service;

import com.api.projettransversal.validation.api.request.ValidationProjection;

import java.util.List;
import java.util.Map;

public interface ValidationService {
    List<ValidationProjection> getAll(Long id,String email);

    Map<String, String> isValid(Long id, String email);
}
