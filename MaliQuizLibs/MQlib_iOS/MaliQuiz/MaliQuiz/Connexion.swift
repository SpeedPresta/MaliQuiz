//
//  Connexion.swift
//  SmartLearning
//
//  Created by esirem on 17/01/2017.
//  Copyright © 2017 Hamadi. All rights reserved.
//

import UIKit

class Connexion: UIViewController {
    
    @IBOutlet weak var user: UITextField!
    @IBOutlet weak var pass: UITextField!
    

    var userDataDico : [String : String] = [:];
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Function changeView
    func toView(view:String) {
        let viewQuiz = Quiz()
        viewQuiz.Name = "tests"
        storyboard?.instantiateViewController(withIdentifier: view)}
    
    // Fonction getUserLogin
    func getLogin()-> String {
        return  user.text!
    }
    
    // Fonction getUserLogin
    func getPass()-> String {
        return  pass.text!
    }

    
    // Fonction pour la recuperation des données utilisateurs
    func LoadUserData(login: String, pass: String) {
        let userd = UserDefaults.standard
        for (key, value) in userd.dictionary(forKey: login)! {
                if(key == login && pass == value as! String) {
                    print("\(key) -> \(value)")
                    Quiz.login = getLogin()
                    performSegue(withIdentifier: "QuizSegue", sender: nil)
                }
        }
    }
    
    @IBAction func start(_ sender: Any) {
        LoadUserData(login: getLogin(), pass:getPass())
    }
    
    // Fonction pour le stockage des données utilisateurs
    func storeUserData(login:String){
        let user = UserDefaults.standard
        user.set(login, forKey: "connected")
        user.synchronize()
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
