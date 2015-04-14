(ns naktis.core)

(defn print-status
  [status]
  (println (str "Eres un " (name (:stereotype status))))
  (println (str "Money: " (:money status) " euros"))
  (println (str "Sex-appeal: " (:sex-appeal status) "/10"))
  (println (str "Mouth power: " (:mouth status) "/10"))
  (println (str "Alcohol in vein: " (:alcohol status)))
  (println (str "The hour is: " (format "%.2f" (:hour status)))))

(defn play
  [status])

(def stereotypes [:pijo, :cani, :heavy, :emo, :hipster, :rapero])

(defn ruleta
  []
  (let [status {:alcohol    0
                :money      (rand-int 100)
                :sex-appeal (rand-int 10)
                :mouth      (rand-int 10)
                :hour       22.00
                :stereotype (rand-nth stereotypes)}]
    (println "Te ha tocado:")
    (print-status status)
    (play status)))

(defn -main
  []
  (println "Comienza el juego, comienza tu naktis...")
  (println "Una naktis dura desde las 22:00 y las 06:00 del día siguiente")
  (println "Sólo saldrás vencedor de ella si consigues ligar con una mujer humana")
  (println "Pero antes que nada, tiremos de la ruleta de la vida...")
  (ruleta))
