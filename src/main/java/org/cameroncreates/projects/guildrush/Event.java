package org.cameroncreates.projects.guildrush;

import com.quiptmc.core.data.registries.Registries;
import com.quiptmc.core.data.registries.Registry;
import org.json.JSONObject;

public record Event(String id, String type, JSONObject data) {

    public static final Registry<Event> EVENTS = Registries.register("events", Event.class);

    public static Event of(JSONObject json) {
        if (!json.has("meta")) throw new IllegalStateException("No meta data");
        JSONObject meta = json.getJSONObject("meta");
        String id = meta.getString("id");
        if (EVENTS.get(id).isPresent()) {
            return EVENTS.get(id).get();
        } else {
            JSONObject data = json.getJSONObject("data");
            String type = meta.getString("event_type");

            Event event = new Event(id, type, data);
            EVENTS.register(id, event);
            return event;
        }
    }

    public String json() {
        JSONObject data = new JSONObject();
        data.put("id", id);
        data.put("type", type);
        data.put("data", this.data);
        return data.toString();
    }

}
