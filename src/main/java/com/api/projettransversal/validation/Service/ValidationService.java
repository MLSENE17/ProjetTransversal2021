package com.api.projettransversal.validation.Service;

import com.api.projettransversal.validation.api.request.ValidationProjection;

import java.util.List;

public interface ValidationService {
    List<ValidationProjection> getAll(Long id);
}
