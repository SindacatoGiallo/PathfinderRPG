import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Character {


    // Qui consrviamo il nome del personaggio

    private String nomePersonaggio;

    // Qui conserviamo la razza del personaggio

    private String razzaPersonaggio;

    // Qui conserviamo la classe del personaggio

    private String classePersonaggio;

    // Qui conserviamo il livello del personaggio  

    private static Integer livelloPersonaggio;

    public static Integer getLivelloPersonaggio() {
        return livelloPersonaggio;
    }

    public static void setLivelloPersonaggio(Integer livelloPersonaggio) {
        Character.livelloPersonaggio = livelloPersonaggio;
    }



    // In questa sezione conserverò le caratteristiche del personaggio
    public static Integer punteggioForza;
    public static Integer punteggioDestrezza;
    public static Integer punteggioCostituzione;
    public static Integer punteggioIntelligenza;
    public static Integer punteggioSaggezza;
    public static Integer punteggioCarisma;

    public static Integer getPunteggioForza() {
        return punteggioForza;
    }

    public static void setPunteggioForza(Integer punteggioForza) {
        Character.punteggioForza = punteggioForza;
    }

    public static Integer getPunteggioDestrezza() {
        return punteggioDestrezza;
    }

    public static void setPunteggioDestrezza(Integer punteggioDestrezza) {
        Character.punteggioDestrezza = punteggioDestrezza;
    }

    public static Integer getPunteggioCostituzione() {
        return punteggioCostituzione;
    }

    public static void setPunteggioCostituzione(Integer punteggioCostituzione) {
        Character.punteggioCostituzione = punteggioCostituzione;
    }

    public static Integer getPunteggioIntelligenza() {
        return punteggioIntelligenza;
    }

    public static void setPunteggioIntelligenza(Integer punteggioIntelligenza) {
        Character.punteggioIntelligenza = punteggioIntelligenza;
    }

    public static Integer getPunteggioSaggezza() {
        return punteggioSaggezza;
    }

    public static void setPunteggioSaggezza(Integer punteggioSaggezza) {
        Character.punteggioSaggezza = punteggioSaggezza;
    }

    public static Integer getPunteggioCarisma() {
        return punteggioCarisma;
    }

    public static void setPunteggioCarisma(Integer punteggioCarisma) {
        Character.punteggioCarisma = punteggioCarisma;
    }



    // In questa sezione conserverò i modificatori delle caratteristiche del personaggio

    private static Integer modificatoreForza = null;
    private static Integer modificatoreDestrezza = null;
    private static Integer modificatoreCostituzione = null;
    private static Integer modificatoreIntelligenza = null;
    private static Integer modificatoreSaggezza = null;
    private static Integer modificatoreCarisma = null;

    // qui di seguito i getters dei modificatori delle caratteristiche

    public static Integer getModificatoreForza() {
        return modificatoreForza;
    }

    public static void setModificatoreForza() {
        Character.modificatoreForza = (int)Math.floor((getPunteggioForza() - 10) / 2);
    }

    public static Integer getModificatoreDestrezza() {
        return modificatoreDestrezza;
    }

    public static void setModificatoreDestrezza() {
        Character.modificatoreDestrezza = (int)Math.floor((getPunteggioDestrezza() - 10) / 2);
    }

    public static Integer getModificatoreCostituzione() {
        return modificatoreCostituzione;
    }

    public static void setModificatoreCostituzione() {
        Character.modificatoreCostituzione = (int)Math.floor((getPunteggioCostituzione() - 10) / 2);
    }

    public static Integer getModificatoreIntelligenza() {
        return modificatoreIntelligenza;
    }

    public static void setModificatoreIntelligenza() {
        Character.modificatoreIntelligenza = (int)Math.floor((getPunteggioIntelligenza() - 10) / 2);
    }

    public static Integer getModificatoreSaggezza() {
        return modificatoreSaggezza;
    }

    public static void setModificatoreSaggezza() {
        Character.modificatoreSaggezza = (int)Math.floor((getPunteggioSaggezza() - 10) / 2);
    }

    public static Integer getModificatoreCarisma() {
        return modificatoreCarisma;
    }

    public static void setModificatoreCarisma() {
        Character.modificatoreCarisma = (int)Math.floor((getPunteggioCarisma() - 10) / 2);
    }

    // In questa sezione conserverò i tiri salvezza del personaggio

    private static Integer tiroSalvezzaTempra;
    private static Integer tiroSalvezzaRiflessi;
    private static Integer tiroSalvezzaVolonta;


    public static Integer calcoloTiroSalvezzaTermpra(Integer livelloPersonaggio){
         return Character.tiroSalvezzaTempra = DadiDaLanciare.lancioDelDadoDaVenti() + CharacterProgressionClass.progressioneTiroSalvezzaTempra.get(livelloPersonaggio) + getModificatoreCostituzione();
    }

    public static Integer calcoloTiroSalvezzaRiflessi(Integer livelloPersonaggio){
        return Character.tiroSalvezzaRiflessi = DadiDaLanciare.lancioDelDadoDaVenti() + CharacterProgressionClass.progressioneTiroSalvezzaRiflessi.get(livelloPersonaggio) + getModificatoreDestrezza();
    }

    public static Integer calcoloTiroSalvezzaVolonta(Integer livelloPersonaggio){
        return Character.tiroSalvezzaVolonta = DadiDaLanciare.lancioDelDadoDaVenti() + CharacterProgressionClass.progressioneTiroSalvezzaVolonta.get(livelloPersonaggio) + getModificatoreSaggezza();
    }


    // Qui calcolo il tiro per colpire in mischia


    //TODO: qui sotto in realtà sto facendo un attacco completo, mi serve un metodo che mi permetta di fare un attacco singolo
    public static List<Integer> attaccoCompleto(Integer livelloPersonaggio,List<Integer> tiriPerColpire){
        //in realtà qui bisogna fare questa operazione per ogni tiro per colpire disponibile
        List<Integer> tiriPerColpireInMischia = new ArrayList<>();
        for (Integer tiroPerColpire : tiriPerColpire){
            tiriPerColpireInMischia.add(tiroPerColpire + CharacterProgressionClass.progressioneBonusAttaccoBase.get(livelloPersonaggio) + getModificatoreForza());
        }


        return tiriPerColpireInMischia;
    }

    public static List<Integer> attaccoSingolo(Integer livelloPersonaggio){
        List<Integer> tiroPerColpireInMischia = new ArrayList<>();
        tiroPerColpireInMischia.add(DadiDaLanciare.lancioDelDadoDaVenti() + CharacterProgressionClass.progressioneBonusAttaccoBase.get(livelloPersonaggio) + getModificatoreForza());
        return tiroPerColpireInMischia;
    }

    // Qui calcolo il tiro per colpire a distanza

    public static Integer calcoloTiroPerColpireADistanza(Integer livelloPersonaggio){
        return DadiDaLanciare.lancioDelDadoDaVenti() + CharacterProgressionClass.progressioneBonusAttaccoBase.get(livelloPersonaggio) + getModificatoreDestrezza();
    }


}