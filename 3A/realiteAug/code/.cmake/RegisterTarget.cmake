function(configure_target target_name)
    target_compile_options(${target_name} PRIVATE ${MY_COMPILE_OPTIONS})
    target_compile_definitions(${target_name} PUBLIC ${MY_COMPILE_DEFINITIONS})
endfunction()