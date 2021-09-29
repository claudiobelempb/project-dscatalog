import styled, { css } from 'styled-components';

export const GridOne = styled.div`
  position: relative;
  display: grid;
  grid-template-columns: 1fr;
  width: 100%;
  height: 100%;
  align-items: center;
  ${({ theme }) => css`
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridTwo = styled.div`
  position: relative;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
  ${({ theme }) => css`
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridThree = styled.div`
  position: relative;
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
  ${({ theme }) => css`
    /* background-color: ${theme.colors.blue_50}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridFour = styled.div`
  position: relative;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridFive = styled.div`
  position: relative;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
  ${({ theme }) => css`
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridSix = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(6, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridServen = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridEight = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(8, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridNine = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(9, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridTen = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(10, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridEleven = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(11, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const GridTwelve = styled.div`
  ${({ theme }) => css`
    position: relative;
    display: grid;
    grid-template-columns: repeat(12, 1fr);
    grid-gap: 1rem;
    height: 100%;
    align-items: center;
    background-color: ${theme.colors.blue_50};
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
