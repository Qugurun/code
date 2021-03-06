package com.facebook.react.bridge;

public enum ReactMarkerConstants
{
  static
  {
    CREATE_REACT_CONTEXT_END = new ReactMarkerConstants("CREATE_REACT_CONTEXT_END", 1);
    PROCESS_PACKAGES_START = new ReactMarkerConstants("PROCESS_PACKAGES_START", 2);
    PROCESS_PACKAGES_END = new ReactMarkerConstants("PROCESS_PACKAGES_END", 3);
    BUILD_NATIVE_MODULE_REGISTRY_START = new ReactMarkerConstants("BUILD_NATIVE_MODULE_REGISTRY_START", 4);
    BUILD_NATIVE_MODULE_REGISTRY_END = new ReactMarkerConstants("BUILD_NATIVE_MODULE_REGISTRY_END", 5);
    CREATE_CATALYST_INSTANCE_START = new ReactMarkerConstants("CREATE_CATALYST_INSTANCE_START", 6);
    CREATE_CATALYST_INSTANCE_END = new ReactMarkerConstants("CREATE_CATALYST_INSTANCE_END", 7);
    DESTROY_CATALYST_INSTANCE_START = new ReactMarkerConstants("DESTROY_CATALYST_INSTANCE_START", 8);
    DESTROY_CATALYST_INSTANCE_END = new ReactMarkerConstants("DESTROY_CATALYST_INSTANCE_END", 9);
    RUN_JS_BUNDLE_START = new ReactMarkerConstants("RUN_JS_BUNDLE_START", 10);
    RUN_JS_BUNDLE_END = new ReactMarkerConstants("RUN_JS_BUNDLE_END", 11);
    NATIVE_MODULE_INITIALIZE_START = new ReactMarkerConstants("NATIVE_MODULE_INITIALIZE_START", 12);
    NATIVE_MODULE_INITIALIZE_END = new ReactMarkerConstants("NATIVE_MODULE_INITIALIZE_END", 13);
    SETUP_REACT_CONTEXT_START = new ReactMarkerConstants("SETUP_REACT_CONTEXT_START", 14);
    SETUP_REACT_CONTEXT_END = new ReactMarkerConstants("SETUP_REACT_CONTEXT_END", 15);
    CHANGE_THREAD_PRIORITY = new ReactMarkerConstants("CHANGE_THREAD_PRIORITY", 16);
    CREATE_UI_MANAGER_MODULE_START = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_START", 17);
    CREATE_UI_MANAGER_MODULE_END = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_END", 18);
    CREATE_VIEW_MANAGERS_START = new ReactMarkerConstants("CREATE_VIEW_MANAGERS_START", 19);
    CREATE_VIEW_MANAGERS_END = new ReactMarkerConstants("CREATE_VIEW_MANAGERS_END", 20);
    CREATE_UI_MANAGER_MODULE_CONSTANTS_START = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_CONSTANTS_START", 21);
    CREATE_UI_MANAGER_MODULE_CONSTANTS_END = new ReactMarkerConstants("CREATE_UI_MANAGER_MODULE_CONSTANTS_END", 22);
    NATIVE_MODULE_SETUP_START = new ReactMarkerConstants("NATIVE_MODULE_SETUP_START", 23);
    NATIVE_MODULE_SETUP_END = new ReactMarkerConstants("NATIVE_MODULE_SETUP_END", 24);
    CREATE_MODULE_START = new ReactMarkerConstants("CREATE_MODULE_START", 25);
    CREATE_MODULE_END = new ReactMarkerConstants("CREATE_MODULE_END", 26);
    PROCESS_CORE_REACT_PACKAGE_START = new ReactMarkerConstants("PROCESS_CORE_REACT_PACKAGE_START", 27);
    PROCESS_CORE_REACT_PACKAGE_END = new ReactMarkerConstants("PROCESS_CORE_REACT_PACKAGE_END", 28);
    CREATE_I18N_MODULE_CONSTANTS_START = new ReactMarkerConstants("CREATE_I18N_MODULE_CONSTANTS_START", 29);
    CREATE_I18N_MODULE_CONSTANTS_END = new ReactMarkerConstants("CREATE_I18N_MODULE_CONSTANTS_END", 30);
    I18N_MODULE_CONSTANTS_CONVERT_START = new ReactMarkerConstants("I18N_MODULE_CONSTANTS_CONVERT_START", 31);
    I18N_MODULE_CONSTANTS_CONVERT_END = new ReactMarkerConstants("I18N_MODULE_CONSTANTS_CONVERT_END", 32);
    CREATE_I18N_ASSETS_MODULE_START = new ReactMarkerConstants("CREATE_I18N_ASSETS_MODULE_START", 33);
    CREATE_I18N_ASSETS_MODULE_END = new ReactMarkerConstants("CREATE_I18N_ASSETS_MODULE_END", 34);
    GET_CONSTANTS_START = new ReactMarkerConstants("GET_CONSTANTS_START", 35);
    GET_CONSTANTS_END = new ReactMarkerConstants("GET_CONSTANTS_END", 36);
    INITIALIZE_MODULE_START = new ReactMarkerConstants("INITIALIZE_MODULE_START", 37);
    INITIALIZE_MODULE_END = new ReactMarkerConstants("INITIALIZE_MODULE_END", 38);
    ON_HOST_RESUME_START = new ReactMarkerConstants("ON_HOST_RESUME_START", 39);
    ON_HOST_RESUME_END = new ReactMarkerConstants("ON_HOST_RESUME_END", 40);
    ON_HOST_PAUSE_START = new ReactMarkerConstants("ON_HOST_PAUSE_START", 41);
    ON_HOST_PAUSE_END = new ReactMarkerConstants("ON_HOST_PAUSE_END", 42);
    CONVERT_CONSTANTS_START = new ReactMarkerConstants("CONVERT_CONSTANTS_START", 43);
    CONVERT_CONSTANTS_END = new ReactMarkerConstants("CONVERT_CONSTANTS_END", 44);
    PRE_REACT_CONTEXT_END = new ReactMarkerConstants("PRE_REACT_CONTEXT_END", 45);
    UNPACKING_JS_BUNDLE_LOADER_CHECK_START = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_CHECK_START", 46);
    UNPACKING_JS_BUNDLE_LOADER_CHECK_END = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_CHECK_END", 47);
    UNPACKING_JS_BUNDLE_LOADER_EXTRACTED = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_EXTRACTED", 48);
    UNPACKING_JS_BUNDLE_LOADER_BLOCKED = new ReactMarkerConstants("UNPACKING_JS_BUNDLE_LOADER_BLOCKED", 49);
    loadApplicationScript_startStringConvert = new ReactMarkerConstants("loadApplicationScript_startStringConvert", 50);
    loadApplicationScript_endStringConvert = new ReactMarkerConstants("loadApplicationScript_endStringConvert", 51);
    PRE_SETUP_REACT_CONTEXT_START = new ReactMarkerConstants("PRE_SETUP_REACT_CONTEXT_START", 52);
    PRE_SETUP_REACT_CONTEXT_END = new ReactMarkerConstants("PRE_SETUP_REACT_CONTEXT_END", 53);
    PRE_RUN_JS_BUNDLE_START = new ReactMarkerConstants("PRE_RUN_JS_BUNDLE_START", 54);
    ATTACH_MEASURED_ROOT_VIEWS_START = new ReactMarkerConstants("ATTACH_MEASURED_ROOT_VIEWS_START", 55);
    ATTACH_MEASURED_ROOT_VIEWS_END = new ReactMarkerConstants("ATTACH_MEASURED_ROOT_VIEWS_END", 56);
    CONTENT_APPEARED = new ReactMarkerConstants("CONTENT_APPEARED", 57);
    RELOAD = new ReactMarkerConstants("RELOAD", 58);
    DOWNLOAD_START = new ReactMarkerConstants("DOWNLOAD_START", 59);
    DOWNLOAD_END = new ReactMarkerConstants("DOWNLOAD_END", 60);
    REACT_CONTEXT_THREAD_START = new ReactMarkerConstants("REACT_CONTEXT_THREAD_START", 61);
    REACT_CONTEXT_THREAD_END = new ReactMarkerConstants("REACT_CONTEXT_THREAD_END", 62);
    GET_REACT_INSTANCE_MANAGER_START = new ReactMarkerConstants("GET_REACT_INSTANCE_MANAGER_START", 63);
    GET_REACT_INSTANCE_MANAGER_END = new ReactMarkerConstants("GET_REACT_INSTANCE_MANAGER_END", 64);
    GET_REACT_INSTANCE_HOLDER_SPEC_START = new ReactMarkerConstants("GET_REACT_INSTANCE_HOLDER_SPEC_START", 65);
    GET_REACT_INSTANCE_HOLDER_SPEC_END = new ReactMarkerConstants("GET_REACT_INSTANCE_HOLDER_SPEC_END", 66);
    BUILD_REACT_INSTANCE_MANAGER_START = new ReactMarkerConstants("BUILD_REACT_INSTANCE_MANAGER_START", 67);
    BUILD_REACT_INSTANCE_MANAGER_END = new ReactMarkerConstants("BUILD_REACT_INSTANCE_MANAGER_END", 68);
    PROCESS_INFRA_PACKAGE_START = new ReactMarkerConstants("PROCESS_INFRA_PACKAGE_START", 69);
    PROCESS_INFRA_PACKAGE_END = new ReactMarkerConstants("PROCESS_INFRA_PACKAGE_END", 70);
    PROCESS_PRODUCT_PACKAGE_START = new ReactMarkerConstants("PROCESS_PRODUCT_PACKAGE_START", 71);
    PROCESS_PRODUCT_PACKAGE_END = new ReactMarkerConstants("PROCESS_PRODUCT_PACKAGE_END", 72);
    CREATE_MC_MODULE_START = new ReactMarkerConstants("CREATE_MC_MODULE_START", 73);
    CREATE_MC_MODULE_END = new ReactMarkerConstants("CREATE_MC_MODULE_END", 74);
    CREATE_MC_MODULE_GET_METADATA_START = new ReactMarkerConstants("CREATE_MC_MODULE_GET_METADATA_START", 75);
    CREATE_MC_MODULE_GET_METADATA_END = new ReactMarkerConstants("CREATE_MC_MODULE_GET_METADATA_END", 76);
    REGISTER_JS_SEGMENT_START = new ReactMarkerConstants("REGISTER_JS_SEGMENT_START", 77);
    REGISTER_JS_SEGMENT_STOP = new ReactMarkerConstants("REGISTER_JS_SEGMENT_STOP", 78);
    VM_INIT = new ReactMarkerConstants("VM_INIT", 79);
    ON_FRAGMENT_CREATE = new ReactMarkerConstants("ON_FRAGMENT_CREATE", 80);
    JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START = new ReactMarkerConstants("JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START", 81);
    JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END = new ReactMarkerConstants("JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END", 82);
    LOAD_REACT_NATIVE_SO_FILE_START = new ReactMarkerConstants("LOAD_REACT_NATIVE_SO_FILE_START", 83);
    LOAD_REACT_NATIVE_SO_FILE_END = new ReactMarkerConstants("LOAD_REACT_NATIVE_SO_FILE_END", 84);
    LOAD_REACT_NATIVE_FABRIC_SO_FILE_START = new ReactMarkerConstants("LOAD_REACT_NATIVE_FABRIC_SO_FILE_START", 85);
    LOAD_REACT_NATIVE_FABRIC_SO_FILE_END = new ReactMarkerConstants("LOAD_REACT_NATIVE_FABRIC_SO_FILE_END", 86);
    ReactMarkerConstants[] arrayOfReactMarkerConstants = new ReactMarkerConstants[87];
    arrayOfReactMarkerConstants[0] = CREATE_REACT_CONTEXT_START;
    arrayOfReactMarkerConstants[1] = CREATE_REACT_CONTEXT_END;
    arrayOfReactMarkerConstants[2] = PROCESS_PACKAGES_START;
    arrayOfReactMarkerConstants[3] = PROCESS_PACKAGES_END;
    arrayOfReactMarkerConstants[4] = BUILD_NATIVE_MODULE_REGISTRY_START;
    arrayOfReactMarkerConstants[5] = BUILD_NATIVE_MODULE_REGISTRY_END;
    arrayOfReactMarkerConstants[6] = CREATE_CATALYST_INSTANCE_START;
    arrayOfReactMarkerConstants[7] = CREATE_CATALYST_INSTANCE_END;
    arrayOfReactMarkerConstants[8] = DESTROY_CATALYST_INSTANCE_START;
    arrayOfReactMarkerConstants[9] = DESTROY_CATALYST_INSTANCE_END;
    arrayOfReactMarkerConstants[10] = RUN_JS_BUNDLE_START;
    arrayOfReactMarkerConstants[11] = RUN_JS_BUNDLE_END;
    arrayOfReactMarkerConstants[12] = NATIVE_MODULE_INITIALIZE_START;
    arrayOfReactMarkerConstants[13] = NATIVE_MODULE_INITIALIZE_END;
    arrayOfReactMarkerConstants[14] = SETUP_REACT_CONTEXT_START;
    arrayOfReactMarkerConstants[15] = SETUP_REACT_CONTEXT_END;
    arrayOfReactMarkerConstants[16] = CHANGE_THREAD_PRIORITY;
    arrayOfReactMarkerConstants[17] = CREATE_UI_MANAGER_MODULE_START;
    arrayOfReactMarkerConstants[18] = CREATE_UI_MANAGER_MODULE_END;
    arrayOfReactMarkerConstants[19] = CREATE_VIEW_MANAGERS_START;
    arrayOfReactMarkerConstants[20] = CREATE_VIEW_MANAGERS_END;
    arrayOfReactMarkerConstants[21] = CREATE_UI_MANAGER_MODULE_CONSTANTS_START;
    arrayOfReactMarkerConstants[22] = CREATE_UI_MANAGER_MODULE_CONSTANTS_END;
    arrayOfReactMarkerConstants[23] = NATIVE_MODULE_SETUP_START;
    arrayOfReactMarkerConstants[24] = NATIVE_MODULE_SETUP_END;
    arrayOfReactMarkerConstants[25] = CREATE_MODULE_START;
    arrayOfReactMarkerConstants[26] = CREATE_MODULE_END;
    arrayOfReactMarkerConstants[27] = PROCESS_CORE_REACT_PACKAGE_START;
    arrayOfReactMarkerConstants[28] = PROCESS_CORE_REACT_PACKAGE_END;
    arrayOfReactMarkerConstants[29] = CREATE_I18N_MODULE_CONSTANTS_START;
    arrayOfReactMarkerConstants[30] = CREATE_I18N_MODULE_CONSTANTS_END;
    arrayOfReactMarkerConstants[31] = I18N_MODULE_CONSTANTS_CONVERT_START;
    arrayOfReactMarkerConstants[32] = I18N_MODULE_CONSTANTS_CONVERT_END;
    arrayOfReactMarkerConstants[33] = CREATE_I18N_ASSETS_MODULE_START;
    arrayOfReactMarkerConstants[34] = CREATE_I18N_ASSETS_MODULE_END;
    arrayOfReactMarkerConstants[35] = GET_CONSTANTS_START;
    arrayOfReactMarkerConstants[36] = GET_CONSTANTS_END;
    arrayOfReactMarkerConstants[37] = INITIALIZE_MODULE_START;
    arrayOfReactMarkerConstants[38] = INITIALIZE_MODULE_END;
    arrayOfReactMarkerConstants[39] = ON_HOST_RESUME_START;
    arrayOfReactMarkerConstants[40] = ON_HOST_RESUME_END;
    arrayOfReactMarkerConstants[41] = ON_HOST_PAUSE_START;
    arrayOfReactMarkerConstants[42] = ON_HOST_PAUSE_END;
    arrayOfReactMarkerConstants[43] = CONVERT_CONSTANTS_START;
    arrayOfReactMarkerConstants[44] = CONVERT_CONSTANTS_END;
    arrayOfReactMarkerConstants[45] = PRE_REACT_CONTEXT_END;
    arrayOfReactMarkerConstants[46] = UNPACKING_JS_BUNDLE_LOADER_CHECK_START;
    arrayOfReactMarkerConstants[47] = UNPACKING_JS_BUNDLE_LOADER_CHECK_END;
    arrayOfReactMarkerConstants[48] = UNPACKING_JS_BUNDLE_LOADER_EXTRACTED;
    arrayOfReactMarkerConstants[49] = UNPACKING_JS_BUNDLE_LOADER_BLOCKED;
    arrayOfReactMarkerConstants[50] = loadApplicationScript_startStringConvert;
    arrayOfReactMarkerConstants[51] = loadApplicationScript_endStringConvert;
    arrayOfReactMarkerConstants[52] = PRE_SETUP_REACT_CONTEXT_START;
    arrayOfReactMarkerConstants[53] = PRE_SETUP_REACT_CONTEXT_END;
    arrayOfReactMarkerConstants[54] = PRE_RUN_JS_BUNDLE_START;
    arrayOfReactMarkerConstants[55] = ATTACH_MEASURED_ROOT_VIEWS_START;
    arrayOfReactMarkerConstants[56] = ATTACH_MEASURED_ROOT_VIEWS_END;
    arrayOfReactMarkerConstants[57] = CONTENT_APPEARED;
    arrayOfReactMarkerConstants[58] = RELOAD;
    arrayOfReactMarkerConstants[59] = DOWNLOAD_START;
    arrayOfReactMarkerConstants[60] = DOWNLOAD_END;
    arrayOfReactMarkerConstants[61] = REACT_CONTEXT_THREAD_START;
    arrayOfReactMarkerConstants[62] = REACT_CONTEXT_THREAD_END;
    arrayOfReactMarkerConstants[63] = GET_REACT_INSTANCE_MANAGER_START;
    arrayOfReactMarkerConstants[64] = GET_REACT_INSTANCE_MANAGER_END;
    arrayOfReactMarkerConstants[65] = GET_REACT_INSTANCE_HOLDER_SPEC_START;
    arrayOfReactMarkerConstants[66] = GET_REACT_INSTANCE_HOLDER_SPEC_END;
    arrayOfReactMarkerConstants[67] = BUILD_REACT_INSTANCE_MANAGER_START;
    arrayOfReactMarkerConstants[68] = BUILD_REACT_INSTANCE_MANAGER_END;
    arrayOfReactMarkerConstants[69] = PROCESS_INFRA_PACKAGE_START;
    arrayOfReactMarkerConstants[70] = PROCESS_INFRA_PACKAGE_END;
    arrayOfReactMarkerConstants[71] = PROCESS_PRODUCT_PACKAGE_START;
    arrayOfReactMarkerConstants[72] = PROCESS_PRODUCT_PACKAGE_END;
    arrayOfReactMarkerConstants[73] = CREATE_MC_MODULE_START;
    arrayOfReactMarkerConstants[74] = CREATE_MC_MODULE_END;
    arrayOfReactMarkerConstants[75] = CREATE_MC_MODULE_GET_METADATA_START;
    arrayOfReactMarkerConstants[76] = CREATE_MC_MODULE_GET_METADATA_END;
    arrayOfReactMarkerConstants[77] = REGISTER_JS_SEGMENT_START;
    arrayOfReactMarkerConstants[78] = REGISTER_JS_SEGMENT_STOP;
    arrayOfReactMarkerConstants[79] = VM_INIT;
    arrayOfReactMarkerConstants[80] = ON_FRAGMENT_CREATE;
    arrayOfReactMarkerConstants[81] = JAVASCRIPT_EXECUTOR_FACTORY_INJECT_START;
    arrayOfReactMarkerConstants[82] = JAVASCRIPT_EXECUTOR_FACTORY_INJECT_END;
    arrayOfReactMarkerConstants[83] = LOAD_REACT_NATIVE_SO_FILE_START;
    arrayOfReactMarkerConstants[84] = LOAD_REACT_NATIVE_SO_FILE_END;
    arrayOfReactMarkerConstants[85] = LOAD_REACT_NATIVE_FABRIC_SO_FILE_START;
    arrayOfReactMarkerConstants[86] = LOAD_REACT_NATIVE_FABRIC_SO_FILE_END;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactMarkerConstants
 * JD-Core Version:    0.6.2
 */