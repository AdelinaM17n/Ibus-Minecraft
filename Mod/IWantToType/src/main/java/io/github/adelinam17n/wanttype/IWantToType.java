package io.github.adelinam17n.wanttype;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.apache.commons.lang3.SystemUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

public class IWantToType implements ModInitializer{
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        if (!System.getenv("GLFW_IM_MODULE").equals("ibus")) {
            System.err.println("Set the GLFW_IM_MODULE env variable to ibus");
        }
    }


}
