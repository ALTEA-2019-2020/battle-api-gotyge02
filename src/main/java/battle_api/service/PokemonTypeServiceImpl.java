package battle_api.service;

import battle_api.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    private RestTemplate restTemplate;
    private String pokemonServiceUrl;
    @Override
    public List<PokemonType> listPokemonsTypes() {
        var result = restTemplate.getForObject(pokemonServiceUrl+"/pokemon-types/", PokemonType[].class);
        return List.of(result);
    }
    @Override
    public List<PokemonType> listPokemonsTypes(List<Integer> ids) {
        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.add("Accept-Language", LocaleContextHolder.getLocale().toLanguageTag());
        HttpEntity entity = new HttpEntity(headers);
        List<PokemonType> pokemonTypes = new ArrayList<>();
        ids.stream().forEach(pokemonId ->
                pokemonTypes
                        .add(restTemplate.exchange(
                                pokemonServiceUrl+"/pokemon-types/"+pokemonId,
                                HttpMethod.GET,
                                entity,
                                PokemonType.class)
                                .getBody())
        );
        return pokemonTypes;
    }
    public PokemonType getPokemon(int id) {
        return restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/"+id, PokemonType.class);
    }
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}