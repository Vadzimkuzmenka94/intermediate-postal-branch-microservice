package ru.skyeng.test.project.core.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Вид почтового отправления",
        enumAsRef = true,
        description = """
                Статус полученного ответа:
                * `LETTER`  - ПИСЬМО
                * `PARCEL`  - ПОСЫЛКА
                * `SMALL_PACKAGE`  - БАНДЕРОЛЬ
                * `POSTCARD`  - ОТКРЫТКА"""
)
public enum PostType {
    LETTER, PARCEL, SMALL_PACKAGE, POSTCARD;
}
