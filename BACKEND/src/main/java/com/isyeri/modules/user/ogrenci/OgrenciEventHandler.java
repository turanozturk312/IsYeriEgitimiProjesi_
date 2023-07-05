package com.isyeri.modules.user.ogrenci;

import com.isyeri.modules.user.ogrenci.entity.Ogrenci;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@RepositoryEventHandler(Ogrenci.class)
public class OgrenciEventHandler {





}
