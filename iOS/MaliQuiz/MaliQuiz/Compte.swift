//
//  Compte.swift
//  SmartLearning
//
//  Created by esirem on 17/01/2017.
//  Copyright © 2017 Hamadi. All rights reserved.
//

import UIKit

class Compte: UIViewController {
    
    @IBOutlet weak var user: UITextField!
    @IBOutlet weak var pass: UITextField!
    @IBOutlet weak var sexe: UITextField!
    @IBOutlet weak var age: UITextField!
    
    var userDataDico: [String : String] = [:]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        //LoadUserData()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Fonction pour le stockage des données utilisateurs
    func storeUserData(){
        let user = UserDefaults.standard
        user.set(userDataDico, forKey: self.user.text!)
        user.synchronize()
    }
    
    @IBAction func creation(_ sender: Any) {
        
        let userData = sexe.text! + "/" + age.text!
        userDataDico  = [user.text!:pass.text!, "info":userData]
        
        if(pass.text! != "" && user.text! != "") {
            storeUserData()
        }
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
