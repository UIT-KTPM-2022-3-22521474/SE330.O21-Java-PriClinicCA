package org.example.privateclinicwebsitespringboot.Service;

import org.example.privateclinicwebsitespringboot.DTO.AppointmentDTO;
import org.example.privateclinicwebsitespringboot.Model.Appointment;
import org.example.privateclinicwebsitespringboot.Model.MyUser;
import org.example.privateclinicwebsitespringboot.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(AppointmentDTO appointmentDTO, MyUser myUser){
        Appointment appointment = new Appointment();
        appointment.setDate(appointmentDTO.getDate());
        appointment.setNote(appointmentDTO.getNote());
        //appointment.setStatus("Pending");
        appointment.setPatient(myUser.getPatient());
        appointment.setDoctor(null);
        appointmentRepository.save(appointment);
        return appointment;
    }

    
}
