package com.laigeoffer.pmhub.base.core.utils;

import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.exception.ServiceException;

import java.util.Objects;

public class ResultUtils {

    public static <T> T result (R<T> data, String message) {
        if (Objects.isNull(data) || Objects.isNull(data.getData())
                || R.fail().equals(data.getData())) {
            throw new ServiceException(message);
        }
        return data.getData();
    }
}
