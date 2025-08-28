/*
 * This file is part of ImmediatelyFast - https://github.com/RaphiMC/ImmediatelyFast
 * Copyright (C) 2023-2025 RK_01/RaphiMC and contributors
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.criticalrange.immediatelyfast_vulkanized.compat;

import com.criticalrange.immediatelyfast_vulkanized.ImmediatelyFast;
import com.criticalrange.immediatelyfast_vulkanized.PlatformCode;
import com.criticalrange.immediatelyfast_vulkanized.feature.core.ImmediatelyFastConfig;

public class VulkanModCompat {

    public static boolean VULKANMOD_LOADED = false;
    public static String VULKANMOD_VERSION = null;

    public static void init() {
        PlatformCode.getModVersion("vulkanmod").ifPresent(version -> {
            VULKANMOD_LOADED = true;
            VULKANMOD_VERSION = version;
            ImmediatelyFast.LOGGER.info("Found VulkanMod " + version + ". Enabling Vulkan compatibility mode.");

            // Enable VulkanMod compatible optimizations
            enableVulkanCompatibleOptimizations();
        });
    }

    private static void enableVulkanCompatibleOptimizations() {
        // Selective optimizations are controlled at mixin plugin level
        ImmediatelyFast.LOGGER.info("VulkanMod selective optimizations are controlled by mixin plugin");
    }

    public static boolean isVulkanModLoaded() {
        return VULKANMOD_LOADED;
    }

    public static boolean shouldDisableOpenGLOptimizations() {
        // Disable OpenGL-based optimizations when VulkanMod is loaded and setting is enabled
        // For safety, always disable when VulkanMod is loaded
        return VULKANMOD_LOADED;
    }

    public static boolean shouldEnableSafeTextureOptimizations() {
        // Enable safe texture optimizations when VulkanMod is loaded
        return VULKANMOD_LOADED && ImmediatelyFast.config.vulkanmod_enable_safe_texture_optimizations;
    }

    public static boolean shouldEnableSafeTextOptimizations() {
        // Enable safe text optimizations when VulkanMod is loaded
        return VULKANMOD_LOADED && ImmediatelyFast.config.vulkanmod_enable_safe_text_optimizations;
    }

}
