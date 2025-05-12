#!/usr/bin/env bb

(require '[clojure.edn]
         '[clojure.java.shell :refer [sh]])

; TODO: Needs to be updated
; type MasterPackages = Map<Keyword, Vector<String> | MasterPackages>
; TODO: First uninstall all brew packages and then install the ones in packages.edn
(defn installation
  {:brew "brew install"}
  {:brew/cask "brew install --cask"}
  {:manual "echo install this yourself"}
  {:pre-installed nil})
 
(defn deserialize [file-name]
  (-> (slurp file-name)
      (clojure.edn/read-string)))

(defn install-packages [master-packages]
  (doseq [[_package-category packages] master-packages]
    (if (vector? packages)
      (doseq [package packages]
        (sh (str "packages/" package ".sh")))
      (install-packages packages))))

(defn main [file-name]
  (-> file-name
      (deserialize)
      (install-packages)))

(main "packages.edn")
