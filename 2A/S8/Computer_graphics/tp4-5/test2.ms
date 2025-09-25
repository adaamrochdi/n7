
function CopyRuleToFile r filePath =
(
    s = ""
    s += r.Name + "\n"
    s += r.Description + "\n"

    local ok = writeToFile s filePath     -- on récupère la valeur de retour
    return ok                             
)
function Print_Validator v =
(
    res = true                      -- devient false si une écriture échoue

    foreach r in v.PublishRules do        
    (
        print r.Name
        print r.Description
        if not (CopyRuleToFile r (@"D:/ExportPocPoc/Publish_" + r.Name + ".txt")) do res = false
    )
    foreach r in v.CheckRules do          
    (
        print r.Name
        print r.Description
        if not (CopyRuleToFile r (@"D:/ExportPocPoc/Check_" + r.Name + ".txt")) do res = false
    )
    return res                            
)
foreach o in PocPoc.Validators do (
   res = Print_Validator o    
   if res ==false do (
       print ("Erreur d'écriture dans le fichier pour le validator: " + o.Name)
   )
   else (
       print ("Ecriture réussie pour le validator: " + o.Name)
   )
)