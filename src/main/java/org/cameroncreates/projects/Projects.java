package org.cameroncreates.projects;


import com.quiptmc.core.annotations.Nullable;

public enum Projects {

    QAPI(
            "API",
            "Cameron Witcher",
            "Quipt API",
            "A RESTful API for the Quipt system.",
            "https://quipt-api.azurewebsites.net/",
            null,
            "qapi/logo.png"),
    QMC(
            "App",
            "Cameron Witcher",
            "Quipt Minecraft",
            "A Minecraft plugin for the Quipt system.",
            "https://modrinth.com/plugin/quipt",
            null,
            "qmc/logo.png"),
    LL4EL2025(
            "Charity",
            "DragonFell",
            "Last Life for Extra Life 2025",
            "A project for the DragonFell Last Life for Extra Life charity event.",
            "https://www.example.com",
            "February 2025",
            "ll4el2025/logo.png",
            "ll4el2025/activities1.png",
            "ll4el2025/activities2.png",
            "ll4el2025/activities3.png"),
    VF(
            "SMP",
            "Cameron Witcher",
            "VanillaFlux",
            "A private SMP server for friends.",
            "https://www.vanillaflux.com",
            null,
            "vf/logo.png"
    );

    private final String category;
    private final String client;
    private final String id;
    private final String description;
    private final String url;
    @Nullable
    private final String date;
    @Nullable
    private final String logo;
    private final String[] images;


    Projects(String category, String client, String name, String description, String url, @Nullable String date, @Nullable String logo, String... images) {
        this.category = category;
        this.client = client;
        this.id = name;
        this.description = description;
        this.url = url;
        this.date = date;
        this.logo = logo;
        this.images = images;
    }

    public String category() {
        return category;
    }

    public String client() {
        return client;
    }

    public String id() {
        return id;
    }

    public String description() {
        return description;
    }

    public String url() {
        return url;
    }

    @Nullable
    public String date() {
        return date;
    }

    @Nullable
    public String logo() {
        return logo;
    }

    public String[] images() {
        return images;
    }

}
