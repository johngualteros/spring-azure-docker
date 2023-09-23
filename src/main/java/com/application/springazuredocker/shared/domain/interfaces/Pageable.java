package com.application.springazuredocker.shared.domain.interfaces;

import org.springframework.data.domain.Sort;

public interface Pageable {
    // number of the current page
    int getPageNumber();
    // size of the pages
    int getPageSize();
    // sorting parameters
    Sort getSort();
}
