(ns henley.view.swing
  (:import (javax.swing UIManager)))

(defn set-look-and-feel2 [name]
  (try
    (loop [infos (UIManager/getInstalledLookAndFeels)]
      (let [info (first infos)]
        (when-not (empty? infos)
          (if (= name (.getName info))
            (do
              (prn "info found")
              (prn info)
              (UIManager/setLookAndFeel (.getClassName info)))
            (recur (rest infos))))))
    (catch Exception e (prn e))))

(defn set-look-and-feel [name]
  (when-let [info (first (filter #(= name (.getName %))
                                 (UIManager/getInstalledLookAndFeels)))]
    (UIManager/setLookAndFeel (.getClassName info))))