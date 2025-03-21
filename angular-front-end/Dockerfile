# Étape de build Angular
FROM node:latest as build
WORKDIR /usr/local/app
COPY . /usr/local/app
RUN npm install
RUN npm run build

# Étape de déploiement avec Nginx
FROM nginx:latest
COPY --from=build /usr/local/app/dist/angular-front-end/browser /usr/share/nginx/html
EXPOSE 80
