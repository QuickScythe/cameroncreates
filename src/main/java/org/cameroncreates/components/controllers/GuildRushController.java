package org.cameroncreates.components.controllers;

import com.quiptmc.core.utils.NetworkUtils;
import org.cameroncreates.feedback.Feedback;
import org.cameroncreates.projects.guildrush.Event;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guildrush")
public class GuildRushController {

    double total = 0;
    double goal = 0;
    Event lastEvent = null;

    @PostMapping("/webhook")
    public String redirectPost(@RequestBody String requestString) {
        JSONObject data = new JSONObject(requestString);
        handleWebhook(data);
        return NetworkUtils.post("http://85.190.130.221:5050/tiltify", data);
    }

    private void handleWebhook(JSONObject data) {
        Event event = Event.of(data);

        if(event.type().equalsIgnoreCase("public:indirect:fact_updated")){
            //Indirect donation
        }
        if(event.type().equalsIgnoreCase("public:direct:fact_updated")){
            //Team stuff
            goal = event.data().getJSONObject("goal").getDouble("value");
            total = event.data().getJSONObject("total_amount_raised").getDouble("value");
        }
        lastEvent = event;
    }

    @GetMapping("/api/{action}")
    public String api(@PathVariable String action){
        if(action.equalsIgnoreCase("total")){
            return new Feedback(Feedback.Result.SUCCESS, "Total amount raised: " + total).json();
        }
        if(action.equalsIgnoreCase("goal")){
            return new Feedback(Feedback.Result.SUCCESS, "Goal amount: " + goal).json();
        }
        if(action.equalsIgnoreCase("last")){
            return new Feedback(Feedback.Result.SUCCESS, "Last event: " + lastEvent.json()).json();
        }

        return new Feedback(Feedback.Result.FAILURE, "Unknown action: " + action).json();
    }
}
