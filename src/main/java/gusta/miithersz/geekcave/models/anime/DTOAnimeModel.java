package gusta.miithersz.geekcave.models.anime;

public record DTOAnimeModel(
                Boolean animePin,
                DTOAnimeTitleModel animeTitle,
                String animeTier,
                String animeImg,
                DTOAnimeStudioModel animeStudio,
                Integer animeSessions,
                String animeStatus,
                String animeSynopsis) {

}
