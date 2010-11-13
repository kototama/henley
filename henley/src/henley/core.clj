(ns henley.core
  (:use henley.controller.register
        henley.view.application
        henley.view.view)
  (:gen-class))

(defn -main [& args]
  (let [app (create-application)]
    (register-listeners app)
    (show app)))
