#!/usr/bin/env bb

(require '[clojure.edn]
         '[clojure.java.shell :refer [sh]])

; A package is {:package-name :installation-method}

; TODO: Needs to be updated
; type MasterPackages = Map<Keyword, Vector<String> | MasterPackages>
; TODO: First uninstall all brew packages and then install the ones in packages.edn

(def packages-already-pre-installed [])
(def packages-to-manually-install [])
(def packages-to-automatically-install [])

(def packages-successfully-installed [])
(def packages-failed-installation [])
 
(defn deserialize [file-name]
  (-> (slurp file-name)
      (clojure.edn/read-string)))

(defn sort-package [package]
  (cond-> package
    (= (:installation-method package) :pre-installed) (conj packages-already-pre-installed)
    (= (:installation-method package) :manual) (conj packages-to-manually-install)
    :else (conj packages-to-automatically-install)))
    
(defn sort-packages [packages]
  (doseq [[k v :as package] packages]
    (if (keyword? k)
      (sort-packages v)
      (sort-package package))))

(defn main [file-name]
  (-> file-name
      (deserialize)
      (sort-packages)))

(main "packages.edn")

(println packages-already-pre-installed)
