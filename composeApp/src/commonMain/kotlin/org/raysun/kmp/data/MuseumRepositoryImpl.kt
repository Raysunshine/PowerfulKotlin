package org.raysun.kmp.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import org.raysun.kmp.domain.repository.MuseumRepository
import org.raysun.kmp.domain.resp.Composition

class MuseumRepositoryImpl(
    private val httpClient: HttpClient,
) : MuseumRepository {
    override suspend fun getComposition(): List<Composition> {
        val compositionString = try {
            httpClient.get("/Kotlin/KMP-App-Template/main/list.json").bodyAsText()
        } catch (e: Exception) {
            compositionBodyString
        }
        return Json.decodeFromString(compositionString)
    }

    private val compositionBodyString = """[
          {
          "objectID": 436535,
          "title": "Wheat Field with Cypresses",
          "artistDisplayName": "Vincent van Gogh",
          "medium": "Oil on canvas",
          "dimensions": "28 7/8 × 36 3/4 in. (73.2 × 93.4 cm)",
          "objectURL": "https://www.metmuseum.org/art/collection/search/436535",
          "objectDate": "1889",
          "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DT1567.jpg",
          "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DT1567.jpg",
          "repository": "Metropolitan Museum of Art, New York, NY",
          "department": "European Paintings",
          "creditLine": "Purchase, The Annenberg Foundation Gift, 1993"
          },
          {
            "objectID": 11207,
            "title": "The Flower Girl",
            "artistDisplayName": "Charles Cromwell Ingham",
            "medium": "Oil on canvas",
            "dimensions": "36 x 28 3/8 in. (91.4 x 72.1 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11207",
            "objectDate": "1846",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT2784.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT2784.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Gift of William Church Osborn, 1902"
          },
          {
            "objectID": 202192,
            "title": "Potpourri vase (pot-pourri gondole)",
            "artistDisplayName": "Sèvres Manufactory",
            "medium": "Soft-paste porcelain decorated in polychrome enamels, gold",
            "dimensions": "Overall, body with lid (confirmed): 12 3/16 x 14 1/4 x 7 3/4 in. (31 x 36.2 x 19.7 cm); Overall, base (confirmed): 2 5/16 x 9 x 5 1/4 in. (5.9 x 22.9 x 13.3 cm); Height assembled (confirmed): 14 1/8 in. (35.9 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/202192",
            "objectDate": "1757",
            "primaryImage": "https://images.metmuseum.org/CRDImages/es/original/DP149951.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/es/web-large/DP149951.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Sculpture and Decorative Arts",
            "creditLine": "Gift of Samuel H. Kress Foundation, 1958"
          },
          {
            "objectID": 11227,
            "title": "Autumn Oaks",
            "artistDisplayName": "George Inness",
            "medium": "Oil on canvas",
            "dimensions": "20 3/8 x 30 1/8 in. (54.3 x 76.5 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11227",
            "objectDate": "ca. 1878",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT264804.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT264804.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Gift of George I. Seney, 1887"
          },
          {
            "objectID": 11120,
            "title": "Fishing Boats, Key West",
            "artistDisplayName": "Winslow Homer",
            "medium": "Watercolor and graphite on off-white wove paper",
            "dimensions": "13 15/16 x 21 3/4 in. (35.4 x 55.2 cm)\r\nFramed: 24 1/2 x 30 1/2 in. (62.2 x 77.5 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11120",
            "objectDate": "1903",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DP119111.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DP119111.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Amelia B. Lazarus Fund, 1910"
          },
          {
            "objectID": 436532,
            "title": "Self-Portrait with a Straw Hat (obverse: The Potato Peeler)",
            "artistDisplayName": "Vincent van Gogh",
            "medium": "Oil on canvas",
            "dimensions": "16 x 12 1/2 in. (40.6 x 31.8 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/436532",
            "objectDate": "1887",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DT1502_cropped2.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DT1502_cropped2.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Paintings",
            "creditLine": "Bequest of Miss Adelaide Milton de Groot (1876-1967), 1967"
          },
          {
            "objectID": 438817,
            "title": "The Dance Class",
            "artistDisplayName": "Edgar Degas",
            "medium": "Oil on canvas",
            "dimensions": "32 7/8 x 30 3/8 in. (83.5 x 77.2 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/438817",
            "objectDate": "1874",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DP-20101-001.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DP-20101-001.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Paintings",
            "creditLine": "Bequest of Mrs. Harry Payne Bingham, 1986"
          },
          {
            "objectID": 10997,
            "title": "Still Life—Violin and Music",
            "artistDisplayName": "William Michael Harnett",
            "medium": "Oil on canvas",
            "dimensions": "40 x 30 in. (101.6 x 76.2 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/10997",
            "objectDate": "1888",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT2046.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT2046.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Catharine Lorillard Wolfe Collection, Wolfe Fund, 1963"
          },
          {
            "objectID": 436528,
            "title": "Irises",
            "artistDisplayName": "Vincent van Gogh",
            "medium": "Oil on canvas",
            "dimensions": "29 x 36 1/4 in. (73.7 x 92.1 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/436528",
            "objectDate": "1890",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DP346474.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DP346474.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Paintings",
            "creditLine": "Gift of Adele R. Levy, 1958"
          },
          {
            "objectID": 13137,
            "title": "The Indian Hunter",
            "artistDisplayName": "John Quincy Adams Ward",
            "medium": "Bronze",
            "dimensions": "16 1/8 x 10 1/2 x 15 1/4 in. (41 x 26.7 x 38.7 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/13137",
            "objectDate": "1860, cast by 1883",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DP259785.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DP259785.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Morris K. Jesup Fund, 1973"
          },
          {
            "objectID": 11619,
            "title": "Cider Making",
            "artistDisplayName": "William Sidney Mount",
            "medium": "Oil on canvas",
            "dimensions": "27 x 34 1/8 in. (68.6 x 86.7 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11619",
            "objectDate": "1840–41",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT72.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT72.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Purchase, Bequest of Charles Allen Munn, by exchange, 1966"
          },
          {
            "objectID": 11737,
            "title": "Still Life with Cake",
            "artistDisplayName": "Raphaelle Peale",
            "medium": "Oil on wood",
            "dimensions": "10 3/4 x 15 1/4 in. (27.3 x 38.7 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11737",
            "objectDate": "1818",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT64.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT64.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Maria DeWitt Jesup Fund, 1959"
          },
          {
            "objectID": 503046,
            "title": "Grand Pianoforte",
            "artistDisplayName": "Érard",
            "medium": "Satinwood veneer, oak, spruce, iron, steel, ebony, ivory, gilding, mother-of-pearl, holly, mahogany, burl walnut, tulipwood, silver wire",
            "dimensions": "Height (Total): 37 1/2 in. (95.3 cm)\r\nWidth (Of case, perpendicular to keyboard): 97 1/4 in. (247 cm)\r\nDepth (Of case, parallel to keyboard): 58 7/8 in. (149.5 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/503046",
            "objectDate": "ca. 1840",
            "primaryImage": "https://images.metmuseum.org/CRDImages/mi/original/DP225545.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/mi/web-large/DP225545.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "Musical Instruments",
            "creditLine": "Gift of Mrs. Henry McSweeney, 1959"
          },
          {
            "objectID": 503219,
            "title": "Division Viol",
            "artistDisplayName": "Richard Meares",
            "medium": "Spruce, ebony, maple",
            "dimensions": "Height: 46 1/16 in. (117 cm)\r\nWidth (At lower bout): 14 3/4 in. (37.4 cm)\r\nDepth (At bottom block): 5 in. (12.7 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/503219",
            "objectDate": "ca. 1680",
            "primaryImage": "https://images.metmuseum.org/CRDImages/mi/original/DP331229.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/mi/web-large/DP331229.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "Musical Instruments",
            "creditLine": "Purchase, Louis V. Bell Fund, Mrs. Vincent Astor Gift, and funds from various donors, 1982"
          },
          {
            "objectID": 11396,
            "title": "Stage Fort across Gloucester Harbor",
            "artistDisplayName": "Fitz Henry Lane (formerly Fitz Hugh Lane)",
            "medium": "Oil on canvas",
            "dimensions": "38 x 60 in. (96.5 x 152.4 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11396",
            "objectDate": "1862",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT5586.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT5586.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Purchase, Rogers and Fletcher Funds, Erving and Joyce Wolf Fund, Raymond J. Horowitz Gift, Bequest of Richard De Wolfe Brixey, by exchange, and John Osgood and Elizabeth Amis Cameron Blanchard Memorial Fund, 1978"
          },
          {
            "objectID": 738466,
            "title": "Modern chromatics : with applications to art and industry",
            "artistDisplayName": "Ogden Nicholas Rood",
            "medium": "",
            "dimensions": "3 pages, 1 leaf, [v]-viii, [9]-329 pages : color frontispiece, illustrations, diagrams ; Height: 7 7/8 in. (20 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/738466",
            "objectDate": "1879",
            "primaryImage": "https://images.metmuseum.org/CRDImages/li/original/b1100612_001.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/li/web-large/b1100612_001.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The Libraries",
            "creditLine": ""
          },
          {
            "objectID": 437299,
            "title": "Jalais Hill, Pontoise",
            "artistDisplayName": "Camille Pissarro",
            "medium": "Oil on canvas",
            "dimensions": "34 1/4 x 45 1/4 in. (87 x 114.9 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/437299",
            "objectDate": "1867",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DT1859.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DT1859.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Paintings",
            "creditLine": "Bequest of William Church Osborn, 1951"
          },
          {
            "objectID": 506174,
            "title": "Kettle Drums",
            "artistDisplayName": "Franz Peter Bundsen",
            "medium": "Silver, iron, calfskin, textiles, gilding,",
            "dimensions": "2010.138.1: 16 1/2 × 23 × 23 in., 52.9 lb. (41.9 × 58.4 × 58.4 cm, 24 kg)\r\n2010.138.2: 16 3/4 × 24 1/2 × 24 1/2 in. (42.5 × 62.2 × 62.2 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/506174",
            "objectDate": "1780",
            "primaryImage": "https://images.metmuseum.org/CRDImages/mi/original/DP229625.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/mi/web-large/DP229625.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "Musical Instruments",
            "creditLine": "Purchase, Robert Alonzo Lehman Bequest, Acquisitions Fund, and Frederick M. Lehman Bequest, 2010"
          },
          {
            "objectID": 11311,
            "title": "Lake George",
            "artistDisplayName": "John Frederick Kensett",
            "medium": "Oil on canvas",
            "dimensions": "44 1/8 x 66 3/8 in. (112.1 x 168.6 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/11311",
            "objectDate": "1869",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT84.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT84.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Bequest of Maria DeWitt Jesup, from the collection of her husband, Morris K. Jesup, 1914"
          },
          {
            "objectID": 250551,
            "title": "Terracotta neck-amphora (jar) with lid and knob (27.16)",
            "artistDisplayName": "Exekias",
            "medium": "Terracotta",
            "dimensions": "H. 18 1/2 in. (47 cm)\r\ndiameter  9 3/4 in. (24.8 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/250551",
            "objectDate": "ca. 540 BCE",
            "primaryImage": "https://images.metmuseum.org/CRDImages/gr/original/DP218568.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/gr/web-large/DP218568.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "Greek and Roman Art",
            "creditLine": "Rogers Fund, 1917"
          },
          {
            "objectID": 14931,
            "title": "A Rose",
            "artistDisplayName": "Thomas Anshutz",
            "medium": "Oil on canvas",
            "dimensions": "58 x 43 7/8 in. (147.3 x 111.4 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/14931",
            "objectDate": "1907",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT104.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT104.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Marguerite and Frank A. Cosgrove Jr. Fund, 1993"
          },
          {
            "objectID": 436323,
            "title": "Marie Emilie Coignet de Courson (1716–1806) with a Dog",
            "artistDisplayName": "Jean Honoré Fragonard",
            "medium": "Oil on canvas",
            "dimensions": "32 x 25 3/4 in. (81.3 x 65.4 cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/436323",
            "objectDate": "ca. 1769",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ep/original/DP-1019-01.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ep/web-large/DP-1019-01.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "European Paintings",
            "creditLine": "Fletcher Fund, 1937"
          },
          {
            "objectID": 459028,
            "title": "Portrait of Alvise Contarini(?); (verso) A Tethered Roebuck",
            "artistDisplayName": "Jacometto (Jacometto Veneziano)",
            "medium": "Oil on wood; verso: oil and gold on wood",
            "dimensions": "Overall 4 5/8 x 3 3/8 in. ; recto, painted surface 4 1/8 x 3 1/8 in.; verso, painted surface 4 3/8 x 3 1/8 in.",
            "objectURL": "https://www.metmuseum.org/art/collection/search/459028",
            "objectDate": "ca. 1485–95",
            "primaryImage": "https://images.metmuseum.org/CRDImages/rl/original/DP221485.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/rl/web-large/DP221485.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "Robert Lehman Collection",
            "creditLine": "Robert Lehman Collection, 1975"
          },
          {
            "objectID": 10481,
            "title": "Heart of the Andes",
            "artistDisplayName": "Frederic Edwin Church",
            "medium": "Oil on canvas",
            "dimensions": "66 1/8 x 120 3/16 in. (168 x 302.9cm)",
            "objectURL": "https://www.metmuseum.org/art/collection/search/10481",
            "objectDate": "1859",
            "primaryImage": "https://images.metmuseum.org/CRDImages/ad/original/DT78.jpg",
            "primaryImageSmall": "https://images.metmuseum.org/CRDImages/ad/web-large/DT78.jpg",
            "repository": "Metropolitan Museum of Art, New York, NY",
            "department": "The American Wing",
            "creditLine": "Bequest of Margaret E. Dows, 1909"
          }
        ]
        """.trimMargin()
}