# InLoco Weather

Objetivo do projeto é mostrar as informações meterológicas.
Dentro do App é possivel visualizar o mapa mundi e selecionar uma coordenada geografica de qualquer lugar.

Após a seleção do local é possivel buscar as informações ao redor do ponto selecionado.
As informações são obtidas através do [Open Weather](htttps://openweather.com)

## Requisitos

Para compilar este projeto em seu computador esta aplicação faz uso das seguintes ferramentas:

- Android Studio
- Gradle
- Google Maps SDK for Android
- InLoco SDK for Android
- Firebase for Android
- Firebase Cloud Message
- Git

## Clonando e Configurando o projeto

Seguem os passos a passo para iniciar o projeto em seu computador.

1. Clonando o projeto usando o git
```bash
git clone git@github.com:LFelipeEB/InLocoWeather.git
```

2. Abrindo o Android Studio e preparando o ambiente para Google Maps e Firebase

Instale o Google Play services SDK. [Acesse o passo a passo](https://developer.android.com/studio/intro/update.html#sdk-manager)

3. Configurando Maps

Acesse o link abaixo pra gerar a Api no Google Clound Console \
[Link rapido para Google Cloud Console](https://console.developers.google.com/flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID&r=37:A2:4B:68:B7:D5:EB:6D:02:4C:7D:04:39:8A:48:FD:57:95:79:5B%3Bcom.example.inlocoweather) \
Siga os passos descritos pela wiizard do Google Console.

Após gerar a chave incluia no arquivo `app/src/main/values/google_maps_api.xml`

4. Configurando Open Weather

Caso não tenha uma conta no OpenWeather, crie um conta atrvés do link: [Sign Up](https://home.openweathermap.org/users/sign_up) \
Com a conta criada é necessario [inscrever](https://openweathermap.org/api) no serviço de Current weather data. \
No painel de [API Keys](https://home.openweathermap.org/api_keys) é listado as API Keys disponíveis. \
Com a API Key gerado inclu-a no arquivo ``app/src/main/values/ope_weather_config.xml`` \

5. Configurando Inloco

Para configurar a conta da InLoco é necessario criar uma aplicação no Painel Inloco\
Após a aplicação criada é gerado uma API-Key. \
Com a API Key gerado inclu-a no arquivo ``app/src/main/values/ope_weather_config.xml`` \

6. Configuando o Push notification

Para configurar o Push Notification e entender o motivo de utiliza-lo é necessario ler a documentação da InLoco. \
[https://docs.inlocoforapps.com/docs/firebase-cloud-messaging](https://docs.inlocoforapps.com/docs/firebase-cloud-messaging) \
Na documentação referenciada acima existe um passo a passo para configurar o FCM.
> Ponto de atenção: Deve ser incluido o arquivo `app\google-services.json`. \
Este arquivo que contém as informações de credenciais e acesso do FCM.

## LICENSE

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.

## Contato
Luiz Evaristo - Github - lfelipeeb@gmail.com