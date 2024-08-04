---
title: Untitled doc
---
&nbsp;

<SwmSnippet path="/src/main/java/gusta/miithersz/geekcave/controllers/anime/AnimeController.java" line="42">

---

&nbsp;

```java
    @PostMapping("/anime")
    @Transactional
    public ResponseEntity<?> postAnime(@RequestBody @Valid DTOAnimeModel anime) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.postAnime(new AnimeModel(anime)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
```

---

</SwmSnippet>

<SwmMeta version="3.0.0" repo-id="Z2l0aHViJTNBJTNBZ2Vla2NhdmUlM0ElM0FNaWlUSGVSc1o=" repo-name="geekcave"><sup>Powered by [Swimm](https://app.swimm.io/)</sup></SwmMeta>
