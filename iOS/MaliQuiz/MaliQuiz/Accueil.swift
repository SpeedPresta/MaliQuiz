//
//  Accueil.swift
//  SmartLearning
//
//  Created by esirem on 23/01/2017.
//  Copyright © 2017 Hamadi. All rights reserved.
//

import UIKit
import Foundation

class Accueil: UIViewController {
    
    @IBOutlet weak var quizLabel: UILabel!
    static var login: String?
    var timer: Timer!
    var counter: Int = 16
    var total: Int = 0
    var quizDico: [Int : String] = [:]
    var currentQuizNb: Int = 0
    var currentQuizstr: String = ""
    var val: Int = 0
    var str: String?
    var dicoInter : [String]?
    var dicoRep : [String]?
    var repq: Int?
    var nbq: Int = 5
    var scorenb: Int = 0
    @IBOutlet weak var counterLabel: UILabel!

    @IBOutlet weak var q1: UIButton!
    @IBOutlet weak var q2: UIButton!
    @IBOutlet weak var q3: UIButton!
    @IBOutlet weak var q4: UIButton!

    @IBOutlet weak var info: UILabel!
    @IBOutlet weak var score: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        initQuiz()
        counterStart()
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // start quiz
    func getQuiz(){
        if let path = Bundle.main.path(forResource: "quiz", ofType: "txt") {
            var myStrings: [String] = []
            do {
            let data = try String(contentsOfFile: path, encoding: .utf8)
            myStrings = data.components(separatedBy: .newlines)
            str = myStrings.joined(separator: ",")
            //nbq += 1
        } catch {
            print(error)
        }
            dicoInter = (str?.components(separatedBy: ","))!
            for (strx) in dicoInter! {
            quizDico = [val : strx]
            val += 1
            print(str!)
         }
       }
        
        if let path = Bundle.main.path(forResource: "Rep", ofType: "txt") {
            var myStrings: [String] = []
            do {
                let data = try String(contentsOfFile: path, encoding: .utf8)
                myStrings = data.components(separatedBy: .newlines)
                str = myStrings.joined(separator: ",")
            } catch {
                print(error)
            }
            dicoRep = (str?.components(separatedBy: ","))!
                }

    }
    
    // lancer le timer
    func counterStart(){    timer = Timer.scheduledTimer(timeInterval: 1, target: self, selector: #selector(timerFunction), userInfo: nil, repeats: true)
        counterLabel.text = "0"
        nextQuiz()
        quizLabel.text = currentQuizstr
        info.text = "..."
        }
    // Counter function called
    func timerFunction() {
        counter -= 1;
        //let x :Float = Float(counter)/Float(total)
        counterLabel.text = "\(counter)"
        
        if(counter == total) {
            timer.invalidate()
            counter = 16
            counterStart()
        }
    }
    
    // Quiz
    //init
    func initQuiz(){
         getQuiz()
        }
    
    func nextQuiz(){
        currentQuizstr = dicoInter![currentQuizNb]
        setQuizLabel(strv: currentQuizNb)
        currentQuizNb += 1
    }
    
    func setQuizLabel(strv: Int) {
        let strInter: String = dicoRep![strv]
        repq = Int(((strInter.components(separatedBy: "#")))[1])!
        q1.setTitle((((((strInter.components(separatedBy: "#"))[0]).components(separatedBy: "*")))[0]), for: .normal)
        q2.setTitle(((((((strInter.components(separatedBy: "#")))[0]).components(separatedBy: "*")))[1]), for: .normal)
        q3.setTitle(((((((strInter.components(separatedBy: "#")))[0]).components(separatedBy: "*")))[2]), for: .normal)
        q4.setTitle(((((((strInter.components(separatedBy: "#")))[0]).components(separatedBy: "*")))[3]), for: .normal)
    }
    
    
    @IBAction func repQ1(_ sender: Any) {
        if(repq==1){setOK()}else{setNOK()}
    }
    
    @IBAction func repQ2(_ sender: Any) {
        if(repq==2){setOK()}else{setNOK()}
    }
    
    @IBAction func repQ3(_ sender: Any) {
        if(repq==3){setOK()}else{setNOK()}
    }
    
    @IBAction func repQ4(_ sender: Any) {
        if(repq==4){setOK()}else{setNOK()}
    }
    
    //Bonne rep
    func setOK(){
        scorenb += 1;
        score.setTitle("Score : \(scorenb)/\(nbq)", for: .normal)
        info.text = "Bonne réponse!"
        timer.invalidate()
        counter = 16
        counterStart()
        
        
        }
    
    //Mauvaise rep
    func setNOK(){
        info.text = "Mauvaise réponse!"
        timer.invalidate()
        counter = 16
        counterStart()
        
        
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
