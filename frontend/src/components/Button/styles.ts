import styled, { css } from 'styled-components';

export const ButtonDefault = styled.button`
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_100};
    color: ${theme.colors.white_100};
    border-radius: 0.3rem;
    margin-bottom: 1rem;
    font-size: 1.2rem;
    font-weight: 700;
    height: 4rem;
    padding: 0.3rem 1rem;
    margin-right: 0.2rem;
    max-width: 20rem;
    min-width: 20rem;

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const ButtonLarge = styled.button`
  position: relative;

  & > div {
    display: block !important;
    position: absolute !important;
    top: 0;
    bottom: 0;
    right: -55px;
  }
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_100};
    color: ${theme.colors.white_100};
    border-radius: 0.3rem;
    margin-bottom: 1rem;
    font-size: 1.2rem;
    font-weight: 700;
    height: 4rem;
    padding: 0.3rem 1rem;
    margin-right: 0.2rem;
    max-width: 20rem;
    min-width: 20rem;

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const ButtonMedium = styled.button`
  position: relative;

  & > div {
    display: block !important;
    position: absolute !important;
    top: 0;
    bottom: 0;
    right: -40px;
  }

  ${({ theme }) => css`
    background-color: ${theme.colors.blue_100};
    color: ${theme.colors.white_100};
    border-radius: 0.3rem;
    margin-bottom: 1rem;
    font-size: 1rem;
    font-weight: 700;
    height: 3rem;
    padding: 0.3rem 1rem;
    margin-right: 0.2rem;
    max-width: 16rem;
    min-width: 16rem;

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }

    /* &::before {
      content: '';
      display: block;
      height: auto;
      width: 48px;
      background-color: ${theme.colors.blue_rgba};
      position: absolute;
      top: 0;
      bottom: 0;
      right: -44px;
      /* left: 0; */
      /* border-radius: 0 10px 10px 0; */
    } */
  `}
`;

export const ButtonSmall = styled.button`
  position: relative;

  & > div {
    display: block !important;
    position: absolute !important;
    top: 0;
    bottom: 0;
    right: -35px;
  }
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_100};
    color: ${theme.colors.white_100};
    border-radius: 0.3rem;
    font-size: 0.8rem;
    font-weight: 700;
    height: 2rem;
    padding: 0.3rem 1rem;
    margin-right: 0.2rem;
    max-width: 13rem;
    min-width: 13rem;
    margin-bottom: 1rem;

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const ButtonFull = styled.button`
  position: relative;

  & > div {
    display: block !important;
    position: absolute !important;
    top: 0;
    bottom: 0;
    right: -40px;
  }
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_100};
    color: ${theme.colors.white_100};
    border-radius: 0.3rem;
    margin-bottom: 1rem;
    font-size: 1rem;
    padding: 0.3rem 1rem;
    margin-right: 0.2rem;
    width: 100%;
    font-weight: bold;
    height: 3rem;
}

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

// .font_mx {
//   font-size: var(--font-mx);
// }
// .font_sx {
//   font-size: var(--font-sx);
// }
// .font_ls {
//   font-size: var(--font-ls);
// }
// .font_ms {
//   font-size: var(--font-ms);
// }
// .font_ss {
//   font-size: var(--font-ss);
// }

// .isUppercase {
//   text-transform: uppercase;
// }
