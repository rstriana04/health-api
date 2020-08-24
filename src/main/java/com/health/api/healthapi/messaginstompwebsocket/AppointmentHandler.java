package com.health.api.healthapi.messaginstompwebsocket;

import com.google.gson.Gson;
import com.health.api.healthapi.models.Appointment;
import com.health.api.healthapi.models.Patient;
import com.health.api.healthapi.models.User;
import com.health.api.healthapi.payload.response.ApiResponseAuth;
import com.health.api.healthapi.services.AppointmentService;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class AppointmentHandler extends TextWebSocketHandler {

    private final AppointmentService appointmentService;

    AppointmentHandler(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        Thread.sleep(1000);
        String payload = message.getPayload();

        Gson gson = new Gson();
        String p = gson.fromJson(payload, String.class);
        JSONObject data = new JSONObject(p);
        Appointment appointment = new Appointment();

        // Set User
        JSONObject userObj = data.getJSONObject("user");
        String citation = data.getString("citation");
        String citationType = data.getString("citationType");
        String type = data.getString("type");

        if (type.equals("create")) {
            User user = new User();
            user.setId(userObj.getLong("id"));
            user.setUsername(userObj.getString("username"));
            user.setEmail(userObj.getString("email"));
            user.setName(userObj.getString("name"));
            user.setLastName(userObj.getString("lastName"));
            user.setDateBirth(userObj.getString("dateBirth"));
            user.setPhone(userObj.getString("phone"));
            user.setGender(userObj.getString("gender"));
            user.setDni(userObj.getString("dni"));
            user.setAccessToken(userObj.getString("accessToken"));


            // Set Patient
            JSONObject patientObj = data.getJSONObject("patient");
            Patient patient = new Patient();
            patient.setId(patientObj.getLong("id"));
            patient.setName(patientObj.getString("name"));
            patient.setLastName(patientObj.getString("lastName"));
            patient.setPhone(patientObj.getString("phone"));
            patient.setGender(patientObj.getString("gender"));
            patient.setDateBirth(patientObj.getString("dateBirth"));
            patient.setUser(user);

            // Create Appointment
            appointment.setCitation(citation);
            appointment.setCitationType(citationType);
            appointment.setPatient(patient);
            appointment.setUser(user);

            try {
                Appointment appointmentCreate = appointmentService.createAppointment(appointment);
                String appointmentResponse = gson.toJson(appointmentCreate);
                session.sendMessage(new TextMessage(appointmentResponse));
            } catch (Exception e) {
                ApiResponseAuth apiResponseFailed = new ApiResponseAuth("failed", "500", null);
                session.sendMessage(new TextMessage(gson.toJson(apiResponseFailed)));
                e.printStackTrace();
                session.close();
            }
        } else if (type.equals("delete")) {
            try {
                Long appointmentId = data.getLong("appointmentId");
                appointmentService.deleteAppointmentById(appointmentId);
                ApiResponseAuth response = new ApiResponseAuth("delete", "200", null);
                session.sendMessage(new TextMessage(gson.toJson(response)));
            } catch (Exception e) {
                ApiResponseAuth response = new ApiResponseAuth("failed", "500", null);
                session.sendMessage(new TextMessage(gson.toJson(response)));
                e.printStackTrace();
            }
        }


    }

}
