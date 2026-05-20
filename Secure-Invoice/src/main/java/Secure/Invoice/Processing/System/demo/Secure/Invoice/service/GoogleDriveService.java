package Secure.Invoice.Processing.System.demo.Secure.Invoice.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

@Service
public class GoogleDriveService {

    private static final String APPLICATION_NAME =
            "Secure Invoice System";

    private static final GsonFactory JSON_FACTORY =
            GsonFactory.getDefaultInstance();

    private static final String TOKENS_DIRECTORY_PATH =
            "tokens";

    private static final java.util.List<String> SCOPES =
            Collections.singletonList(
                    DriveScopes.DRIVE_FILE
            );

    private static final String CREDENTIALS_FILE_PATH =
            "/credentials.json";

    private Credential getCredentials()
            throws IOException, GeneralSecurityException {

        InputStream in =
                GoogleDriveService.class.getResourceAsStream(
                        CREDENTIALS_FILE_PATH
                );

        if (in == null) {

            throw new FileNotFoundException(
                    "credentials.json not found"
            );
        }

        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(
                        JSON_FACTORY,
                        new InputStreamReader(in)
                );

        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        GoogleNetHttpTransport.newTrustedTransport(),
                        JSON_FACTORY,
                        clientSecrets,
                        SCOPES
                )

                        .setDataStoreFactory(
                                new FileDataStoreFactory(
                                        new java.io.File(
                                                TOKENS_DIRECTORY_PATH
                                        )
                                )
                        )

                        .setAccessType("offline")
                        .build();

        LocalServerReceiver receiver =
                new LocalServerReceiver.Builder()
                        .setPort(8888)
                        .build();

        return new AuthorizationCodeInstalledApp(
                flow,
                receiver
        ).authorize("user");
    }

    public String uploadFile(String filePath)
            throws Exception {

        final Drive service =
                new Drive.Builder(
                        GoogleNetHttpTransport
                                .newTrustedTransport(),
                        JSON_FACTORY,
                        getCredentials()
                )

                        .setApplicationName(
                                APPLICATION_NAME
                        )

                        .build();

        com.google.api.services.drive.model.File fileMetadata =
                new com.google.api.services.drive.model.File();

        fileMetadata.setName(
                "invoice-report.xlsx"
        );

        java.io.File filePathObj =
                new java.io.File(filePath);

        FileContent mediaContent =
                new FileContent(
                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                        filePathObj
                );

        com.google.api.services.drive.model.File uploadedFile =
                service.files().create(
                        fileMetadata,
                        mediaContent
                )

                        .setFields("id, webViewLink")
                        .execute();

        System.out.println(
                "File Uploaded Successfully"
        );

        return uploadedFile.getWebViewLink();
    }
}