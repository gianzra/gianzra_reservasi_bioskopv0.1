package com.binar.app.dto;

public record ScheduleDTO(Long schedule_id, Long film_code, String tanggal_tayang, String jam_mulai, String jam_selesai, int harga_tiket) {

}
