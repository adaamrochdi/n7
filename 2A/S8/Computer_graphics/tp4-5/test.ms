
function CopyRuleToFile r filePath = (
    s = ""
    s += r.Name + "\n"
    s += r.Description + "\n"

    writeToFile s filePath   --on ignore la valeur de retour 

    return true              -- renvoie toujours true, même si writeToFile a échoué
)
function Print_Validator v = (
    res = false              --on initialise mais on n’utilise pas 

    foreach r in v.PublishRules do (         
        print r.Name
        print r.Description
        res = CopyRuleToFile r (@"D:/ExportPocPoc/" + r.Name)  -- On doit ajouter une extension et faire une erreur si le dossier n'existe pas
        
    )
    foreach r in o.CheckRules do (           --variable 'o' inexistante, devrait être 'v'
        print r.Name
        print r.Description
        res = CopyRuleToFile r (@"D:/ExportPocPoc/" + r.Name)
    )
    --aucune valeur retournée par la fonction
)
foreach o in PocPoc.Validators do (
    Print_Validator o        
)


